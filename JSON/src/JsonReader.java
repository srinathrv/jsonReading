import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonReader {

	public static void main(String[] args) {
		JsonReader reader = new JsonReader();
		try {
			System.out.println(reader.readJSON(reader.readFile("page_info.json")));
		} catch (JSONException e)

		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private String readJSON(String jsonData) throws JSONException {

		StringBuilder jsonOutput = new StringBuilder();
		JSONObject obj = new JSONObject(jsonData);
		String pageName = obj.getJSONObject("pageInfo").getString("pageName");
		JSONArray arr = obj.getJSONArray(pageName);
		for (int i = 0; i < arr.length(); i++) {
			jsonOutput.append(arr.getJSONObject(i).getString("post_id"));
		}
		return jsonData.toString();
	}

	private String readFile(String file) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line = null;
		StringBuilder stringBuilder = new StringBuilder();
		String ls = System.getProperty("line.separator");

		try {
			while ((line = reader.readLine()) != null) {
				stringBuilder.append(line);
				stringBuilder.append(ls);
			}

			return stringBuilder.toString();
		} finally {
			reader.close();
		}
	}
}