package org.ssssssss.magicapi.modules;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.ssssssss.magicapi.config.MagicModule;
import org.ssssssss.magicapi.model.Constants;
import org.ssssssss.script.reflection.JavaInvoker;
import org.ssssssss.script.reflection.JavaReflection;

import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * mongo模块
 */
public class MongoModule extends HashMap<String, Object> implements MagicModule {

	private static final Logger logger = LoggerFactory.getLogger(MongoModule.class);

	private final MongoTemplate mongoTemplate;
	private final JavaInvoker<Method> mongoDbFactoryInvoker;
	private JavaInvoker<Method> invoker;

	public MongoModule(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
		mongoDbFactoryInvoker = JavaReflection.getMethod(this.mongoTemplate, "getMongoDbFactory");
		if (mongoDbFactoryInvoker != null) {
			try {
				Object factory = mongoDbFactoryInvoker.invoke0(this.mongoTemplate, null, Constants.EMPTY_OBJECT_ARRAY);
				invoker = JavaReflection.getMethod(factory, "getDb", StringUtils.EMPTY);
				if (invoker == null) {
					invoker = JavaReflection.getMethod(factory, "getMongoDatabase", StringUtils.EMPTY);
				}
			} catch (Throwable e) {
				logger.error("mongo模块初始化失败", e);
			}
		} else {
			logger.error("mongo模块初始化失败");
		}
	}

	@Override
	public Object get(Object databaseName) {
		return databaseName == null ? null : new HashMap<String, MongoCollection<Document>>() {
			@Override
			public MongoCollection<Document> get(Object collection) {
				if (collection == null) {
					return null;
				}
				try {
					Object factory = mongoDbFactoryInvoker.invoke0(mongoTemplate, null, Constants.EMPTY_OBJECT_ARRAY);
					MongoDatabase database = (MongoDatabase) invoker.invoke0(factory, null, new Object[]{databaseName.toString()});
					return database.getCollection(collection.toString());
				} catch (Throwable throwable) {
					throw new RuntimeException(throwable);
				}
			}
		};
	}

	@Override
	public String getModuleName() {
		return "mongo";
	}
}
