package cn.ixan.example.test;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.junit.Test;

/**
 * @author stack_zhang@outlook.com
 * @date 2019年3月12日, 0012
 */
public class MongoTest {

	@Test
	public void testConnection(){
		//创建Mongo客户端
		MongoClient client = new MongoClient("localhost", 27017);
		//连接数据库
		MongoDatabase database = client.getDatabase("local");
		//连接Collection
		MongoCollection<Document> collection = database.getCollection("student");
	}
}
