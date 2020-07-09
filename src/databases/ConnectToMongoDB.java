package databases;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import json.parser.NewsHeadline;
import parser.Student;

/**
 * Created by mrahman on 09/09/18.
 */

public class ConnectToMongoDB {

	public static MongoDatabase mongoDatabase = null;

	public static MongoDatabase connectToMongoDB() {
		MongoClient mongoClient = new MongoClient();
		mongoDatabase = mongoClient.getDatabase("students");
		System.out.println("Database Connected");

		return mongoDatabase;
	}

	public static String insertIntoToMongoDB(User user) {
		String profile = user.getStName();
		MongoDatabase mongoDatabase = connectToMongoDB();
		MongoCollection<Document> collection = mongoDatabase.getCollection("profile");
		Document document = new Document().append("stName", user.getStName()).append("stID", user.getStID())
				.append("stDOB", user.getStDOB());
		collection.insertOne(document);
		return profile + " has been registered";
	}

	public String insertIntoMongoDB(List<Student> student, String profileName) {
		MongoDatabase mongoDatabase = connectToMongoDB();
		MongoCollection myCollection = mongoDatabase.getCollection(profileName);
		boolean collectionExists = mongoDatabase.listCollectionNames().into(new ArrayList<String>())
				.contains(profileName);
		if (collectionExists) {
			myCollection.drop();
		}
		for (int i = 0; i < student.size(); i++) {
			MongoCollection<Document> collection = mongoDatabase.getCollection(profileName);
			Document document = new Document().append("firstName", student.get(i).getFirstName())
					.append("lastName", student.get(i).getLastName()).append("score", student.get(i).getScore())
					.append("id", student.get(i).getId());
			collection.insertOne(document);
		}

		return "Student has been registered";
	}

	public static String insertIntoMongoDB1(List<NewsHeadline> news, String profileName) {
		MongoDatabase mongoDatabase = connectToMongoDB();
		MongoCollection myCollection = mongoDatabase.getCollection(profileName);
		boolean collectionExists = mongoDatabase.listCollectionNames().into(new ArrayList<String>())
				.contains(profileName);
		if (collectionExists) {
			myCollection.drop();
		}
		for (int i = 0; i < news.size(); i++) {
			MongoCollection<Document> collection = mongoDatabase.getCollection(profileName);
			Document document = new Document().append("source", news.get(i).getSource())
					.append("author", news.get(i).getAuthor()).append("title", news.get(i).getTitle())
					.append("description", news.get(i).getDescription()).append("url", news.get(i).getUrlToImage())
					.append("urlToImage", news.get(i).getUrlToImage())
					.append("publishedAt", news.get(i).getPublishedAt()).append("content", news.get(i).getContent());
			collection.insertOne(document);
		}

		return "NewsHeadline has been registered";
	}

	public List<NewsHeadline> readStudentListFromMongoDB1(String profileName) {
		List<NewsHeadline> list = new ArrayList<>();
		NewsHeadline news = new NewsHeadline();
		MongoDatabase mongoDatabase = connectToMongoDB();
		MongoCollection<Document> collection = mongoDatabase.getCollection(profileName);
		BasicDBObject basicDBObject = new BasicDBObject();
		FindIterable<Document> iterable = collection.find(basicDBObject);
		for (Document doc : iterable) {
			String source = (String) doc.get("source");
			news.setSource(source);
			String author = (String) doc.get("author");
			news.setAuthor(author);
			String description = (String) doc.get("description");
			news.setDescription(description);
			String title = (String) doc.get("title");
			news.setTitle(title);
			String url = (String) doc.get("url");
			news.setUrl(url);
			String urlToImage = (String) doc.get("urlToImage");
			news.setUrlToImage(urlToImage);
			String publishedAt = (String) doc.get("publishedAt");
			news.setPublishedAt(publishedAt);
			String content = (String) doc.get("content");
			news.setContent(content);
			news = new NewsHeadline(news.getSource(), news.getAuthor(), news.getTitle(), news.getDescription(),
					news.getUrl(), news.getUrlToImage(), news.getPublishedAt(), news.getContent());
			list.add(news);
		}
		return list;
	}

	public static List<User> readUserProfileFromMongoDB() {
		List<User> list = new ArrayList<User>();
		User user = new User();
		MongoDatabase mongoDatabase = connectToMongoDB();
		MongoCollection<Document> collection = mongoDatabase.getCollection("profile");
		BasicDBObject basicDBObject = new BasicDBObject();
		FindIterable<Document> iterable = collection.find(basicDBObject);
		for (Document doc : iterable) {
			String stName = (String) doc.get("stName");
			user.setStName(stName);
			String stID = (String) doc.get("stID");
			user.setStID(stID);
			String stDOB = (String) doc.get("stDOB");
			user.setStID(stDOB);
			user = new User(stName, stID, stDOB);
			list.add(user);
		}
		return list;
	}

	public List<Student> readStudentListFromMongoDB(String profileName) {
		List<Student> list = new ArrayList<Student>();
		Student student = new Student();
		MongoDatabase mongoDatabase = connectToMongoDB();
		MongoCollection<Document> collection = mongoDatabase.getCollection(profileName);
		BasicDBObject basicDBObject = new BasicDBObject();
		FindIterable<Document> iterable = collection.find(basicDBObject);
		for (Document doc : iterable) {
			String firstName = (String) doc.get("firstName");
			student.setFirstName(firstName);
			String lastName = (String) doc.get("lastName");
			student.setLastName(lastName);
			String score = (String) doc.get("score");
			student.setScore(score);
			String id = (String) doc.get("id");
			student.setId(id);
			student = new Student(student.getFirstName(), student.getLastName(), student.getScore(), student.getId());
			list.add(student);
		}
		return list;
	}

	public static void main(String[] args) {
		// insertIntoToMongoDB(new User("Naomi Chan", "4493","07-1996"));
		List<User> user = readUserProfileFromMongoDB();
		for (User person : user) {
			System.out.println(person.getStName() + " " + person.getStID());
		}
	}
}
