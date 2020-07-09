package json.parser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import databases.ConnectToMongoDB;

public class JsonReaderNews {

	public static void main(String[] args) throws MalformedURLException, IOException, NullPointerException {
		String sURL = "https://newsapi.org/v2/top-headlines?sources=cnn&apiKey=c6ced4b2b8b24acd8a7ea4d27e2e8d8b";
		NewsHeadline news = null;
		List<NewsHeadline> newsList = new ArrayList<>();
		URL url1 = new URL(sURL);
		URLConnection request = url1.openConnection();
		request.connect();
		JsonArray jsonArray = null;
		JsonObject rootObj = null;
		JsonParser jp = new JsonParser();
		JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
		if (root instanceof JsonObject) {
			rootObj = root.getAsJsonObject();
		} else if (root instanceof JsonArray) {
			jsonArray = root.getAsJsonArray();
		}
		String status = "";
		status = rootObj.get("status").toString();
		System.out.print(status + " ");
		String totalResults = "";
		totalResults = rootObj.get("totalResults").toString();
		System.out.println(totalResults + " ");
		String articles = "";
		articles = rootObj.get("articles").toString();
		System.out.println(articles + " ");
		System.out.println("--------------------------------------");
		System.out.println("Beginning of parsing from url from jsonArray of articles");
		JsonArray json = rootObj.getAsJsonArray("articles");

		for (int i = 0; i < json.size(); i++) {
			try {

				JsonObject jsonobject = json.get(i).getAsJsonObject();
				// you code start here
				String source = jsonobject.get("source").toString();
				System.out.print(source + " ");
				String author = jsonobject.get("author").toString();
				System.out.print(author + " ");
				String title = jsonobject.get("title").toString();
				System.out.print(title + " ");
				String description = jsonobject.get("description").toString();
				System.out.print(description);
				String url = jsonobject.get("url").toString();
				System.out.print(url);
				String urlToImage = jsonobject.get("urlToImage").toString();
				System.out.print(urlToImage);
				String publishedAt = jsonobject.get("publishedAt").toString();
				System.out.print(publishedAt);
				String content = jsonobject.get("content").toString();
				System.out.print(content);
				System.out.println();
				newsList.add(
						new NewsHeadline(source, author, title, description, url, urlToImage, publishedAt, content));
			} catch (Exception ex) {
				ex.printStackTrace();
			}

		}
		System.out.println("----------------------------------------");
		System.out.println("Getting headlines from list we stored it in:");
		for (NewsHeadline entry : newsList) {
			System.out.println(entry.getSource() + " " + entry.getAuthor() + " " + entry.getTitle() + " "
					+ entry.getDescription() + " " + entry.getUrl() + " " + entry.getUrlToImage() + " "
					+ entry.getPublishedAt() + " " + entry.getContent());
		}
		ConnectToMongoDB.insertIntoMongoDB1(newsList, "News");
		ConnectToMongoDB connectToMongoDB = new ConnectToMongoDB();
		List<NewsHeadline> newsList1 = connectToMongoDB.readStudentListFromMongoDB1("News");
		System.out.println("From MongoDB");
		for (NewsHeadline st : newsList1) {
			System.out.println(st.getSource() + " " + st.getAuthor() + " " + st.getTitle() + " " + st.getDescription()
					+ " " + st.getUrl() + " " + st.getUrlToImage() + " " + st.getPublishedAt() + " " + st.getContent());

		}

	}
}
