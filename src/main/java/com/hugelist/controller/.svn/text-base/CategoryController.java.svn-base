package com.hugelist.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hugelist.client.entities.WSResult;
import com.hugelist.entities.Account;
import com.hugelist.entities.Category;
import com.hugelist.entities.ClassItem;
import com.hugelist.entities.Classification;
import com.hugelist.services.AccountService;
import com.hugelist.services.CategoryService;
import com.hugelist.utils.Utils;

import flexjson.JSONDeserializer;

@Controller
@RequestMapping("/category")
public class CategoryController {

	ApplicationContext context = new ClassPathXmlApplicationContext(
			"SpringConfig.xml"); //$NON-NLS-1$
	AccountService accountService = (AccountService) this.context
			.getBean("accountService"); //$NON-NLS-1$
	CategoryService categoryService = (CategoryService) this.context
			.getBean("categoryService"); //$NON-NLS-1$

	private static final Logger log = LoggerFactory
			.getLogger(CategoryController.class);

	/**
	 * Remove AID and TOKEN
	 * 
	 * @param
	 * @return
	 */
	@RequestMapping(value = "/getListCategory", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody
	String getListCatagoryService(@RequestBody String json) {

		// Get all category
		List<Category> categorys = this.categoryService.findAll();
		if (categorys.size() == 0) {
			return new WSResult<Category>(WSResult.NOT_FOUND,
					"No Category exist on HugeList").toString(); //$NON-NLS-1$
		}

		WSResult<Category> result = new WSResult<Category>("OK", //$NON-NLS-1$
				"Get list category success"); //$NON-NLS-1$
		result.setBaseClass(categorys);

		return result.toString();
	}

	/**
	 * Remove AID and TOKEN
	 * 
	 * @param json
	 *            ( catagoryId )
	 * @return
	 */
	@RequestMapping(value = "/getCategory", method = RequestMethod.POST, headers = "Accept=application/json")
	public @ResponseBody
	String getCatagoryService(@RequestBody String json) {

		JSONObject objson;

		String catagoryId = null;

		try {
			objson = (JSONObject) JSONSerializer.toJSON(json);
			catagoryId = objson.getString("categoryId").trim(); //$NON-NLS-1$

		} catch (Exception e) {
			log.info("Invalid JSON data {} ", json); //$NON-NLS-1$
			return new WSResult<Category>(WSResult.INVALID_JSON,
					"Invalid JSON format. Please check your json input parameter").toString(); //$NON-NLS-1$
		}

		if (catagoryId == null || catagoryId.trim().length() == 0) {
			return new WSResult<Category>(WSResult.NG,
					"Parameter CampaignId is invalid").toString(); //$NON-NLS-1$
		}

		// Validate Campaign
		Category category = this.categoryService.findById(catagoryId);
		if (category == null) {
			return new WSResult<Category>(WSResult.NOT_FOUND,
					"No Category exist on HugeList").toString(); //$NON-NLS-1$
		}
		WSResult<Category> result = new WSResult<Category>("OK", //$NON-NLS-1$
				"Get Category success"); //$NON-NLS-1$
		result.setBaseClass(new ArrayList<Category>());
		result.getBaseClass().add(category);

		return result.toString();
	}

	/**
	 * Delete Category Service
	 * 
	 * @param JSon
	 *            (aid, token , challengeKey , categoryId)
	 * @return
	 */
	@RequestMapping(value = "/deleteCategory", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public @ResponseBody
	WSResult<Category> deleteCategoryService(@RequestBody String json) {

		JSONObject objson;
		String aid = null;
		String token = null;
		String categoryId = null;
		String challengeKey = null;

		try {
			objson = (JSONObject) JSONSerializer.toJSON(json);
			aid = objson.getString("aid").trim(); //$NON-NLS-1$
			token = objson.getString("token").trim(); //$NON-NLS-1$
			categoryId = objson.getString("categoryId").trim(); //$NON-NLS-1$
			challengeKey = objson.getString("challengeKey").trim(); //$NON-NLS-1$
		} catch (Exception e) {
			log.info("Invalid JSON data {} ", json); //$NON-NLS-1$
			return new WSResult<Category>(WSResult.INVALID_JSON,
					"Invalid JSON format. Please check your json input parameter"); //$NON-NLS-1$
		}

		if (aid == null || aid.trim().length() == 0) {
			return new WSResult<Category>(WSResult.NG, "AID is not valid"); //$NON-NLS-1$
		} else if (categoryId == null || categoryId.trim().length() == 0) {
			return new WSResult<Category>("NG", "CategoryId is not valid"); //$NON-NLS-1$ //$NON-NLS-2$
		}

		if (challengeKey == null || challengeKey.equals("")) { //$NON-NLS-1$
			return new WSResult<Category>(WSResult.INVALID_CK,
					"Challenge key is not valid"); //$NON-NLS-1$
		}

		Account accountdb = this.accountService.findById(aid);

		if (accountdb == null) {
			return new WSResult<Category>(WSResult.NOT_FOUND,
					"User corresponding with AID doesn’t exist on HugeList"); //$NON-NLS-1$
		}

		if (accountdb.getToken().equals(token) == false) {
			return new WSResult<Category>(WSResult.INVALID_TOKEN,
					"Your token is invalid. Please try again by re-login"); //$NON-NLS-1$
		}

		if (Utils.isTokenExpired(accountdb)) {
			return new WSResult<Category>("EXPIRED", //$NON-NLS-1$
					"Your working session was expired. Please login again to create a category"); //$NON-NLS-1$
		}

		// Validate Campaign
		Category category = this.categoryService.findById(categoryId);

		if (category == null) {
			return new WSResult<Category>(WSResult.NOT_FOUND,
					"Category doesn’t exist on HugeList"); //$NON-NLS-1$
		}

		this.categoryService.remove(category);

		return new WSResult<Category>("OK", "Delete category success"); //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * 
	 * @param json
	 *            ( aid, token , category )
	 * @return
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonParseException
	 */
	@RequestMapping(value = "/addCategory", method = RequestMethod.PUT, headers = "Accept=application/json")
	public @ResponseBody
	WSResult<String> addCategoryJsonService(@RequestBody String json)
			throws JsonParseException, JsonMappingException, IOException {

		Category category;
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

		JSONObject objson;
		String aid = null;
		String token = null;
		String categoryJSon = null;
		JSONObject categoryJsonObj;
		try {
			objson = (JSONObject) JSONSerializer.toJSON(json);
			aid = objson.getString("aid").trim(); //$NON-NLS-1$
			token = objson.getString("token").trim(); //$NON-NLS-1$
			categoryJSon = objson.getString("category"); //$NON-NLS-1$
			categoryJsonObj = (JSONObject) JSONSerializer.toJSON(categoryJSon);

		} catch (Exception e) {
			log.info("Invalid JSON data {} ", json); //$NON-NLS-1$
			return new WSResult<String>("INVALID_JSON", //$NON-NLS-1$
					"Invalid JSON format. Please check your json input parameter"); //$NON-NLS-1$

		}

		if (aid == null || aid.trim().length() == 0) {
			return new WSResult<String>("NG", "Parameter AID is invalid"); //$NON-NLS-1$ //$NON-NLS-2$

		}

		if (token == null) {
			return new WSResult<String>("INVALID_TOKEN", //$NON-NLS-1$
					"You need login to HugeList to create a category"); //$NON-NLS-1$
		}

		Account accountdb = this.accountService.findById(aid);

		if (accountdb == null) {
			return new WSResult<String>(WSResult.NOT_FOUND,
					"User corresponding with AID doesn’t exist on HugeList"); //$NON-NLS-1$
		}

		if (accountdb.getToken().equals(token) == false) {
			return new WSResult<String>(WSResult.INVALID_TOKEN,
					"Your token is invalid. Please try again by re-login"); //$NON-NLS-1$
		}

		if (Utils.isTokenExpired(accountdb)) {
			return new WSResult<String>("EXPIRED", //$NON-NLS-1$
					"Your working session was expired. Please login again to create a category"); //$NON-NLS-1$
		}

		// Parser and Validate Campaign Json
		try {
			category = new JSONDeserializer<Category>().use(null,
					Category.class).deserialize(categoryJSon);
		} catch (Exception e) {
			return new WSResult<String>("INVALID_CATEGORY", //$NON-NLS-1$
					"Can't Parser Json value"); //$NON-NLS-1$
		}

		if (category == null) {
			return new WSResult<String>("INVALID_CATEGORY", //$NON-NLS-1$
					"Category is not valid"); //$NON-NLS-1$
		}

		String category_id = UUID.randomUUID().toString();

		try {
			String classification_id;
			Set<Classification> lstClassification;
			Set<ClassItem> lstClassItem;
			// Set id key value for fields
			category.setId(category_id);

			// Set id Key value for ClassItemValue
			if (category.getClassifications().size() > 0) {

				lstClassification = new HashSet<Classification>();
				Classification classificationItem = new Classification();
				JSONArray listOfObject = categoryJsonObj
						.getJSONArray("classifications"); //$NON-NLS-1$

				ClassItem classItemInLoop = new ClassItem();

				for (int i = 0; i < listOfObject.size(); i++) {
					String itemStr = listOfObject.getJSONObject(i).toString();
					classificationItem = mapper.readValue(itemStr,
							Classification.class);

					if (classificationItem != null) {
						classification_id = UUID.randomUUID().toString();
						// Set classification id
						classificationItem.setId(classification_id);

						// Set ClassItem id through loop
						objson = (JSONObject) JSONSerializer.toJSON(itemStr);
						JSONArray listOfClassItems = objson
								.getJSONArray("classItems"); //$NON-NLS-1$

						if (listOfClassItems != null
								&& listOfClassItems.size() > 0) {
							lstClassItem = new HashSet<ClassItem>();

							for (int j = 0; j < listOfClassItems.size(); j++) {
								String classItemStr = listOfClassItems
										.getJSONObject(j).toString();
								classItemInLoop = mapper.readValue(
										classItemStr, ClassItem.class);

								if (classItemInLoop != null) {
									classItemInLoop.setId(UUID.randomUUID()
											.toString());

									lstClassItem.add(classItemInLoop);
								}
							}

							classificationItem.setClassItems(lstClassItem);
						}
						lstClassification.add(classificationItem);
					}
				}

				category.setClassifications(lstClassification);
			}

			category.setLatestVersion(1);

			this.categoryService.insert(category);
		} catch (Exception e) {
			log.error(e.getMessage());
			return new WSResult<String>(WSResult.NG, "Can't add this category"); //$NON-NLS-1$
		}

		WSResult<String> result = new WSResult<String>(
				"OK", "Create Category success."); //$NON-NLS-1$ //$NON-NLS-2$

		result.setBaseClass(new ArrayList<String>());

		result.getBaseClass().add(category_id);

		return result;
	}

}
