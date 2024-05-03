package com.keduit.kyj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Projectparsing {

	public static void main(String[] args) throws Exception {
		String key = "DEOJBRmSht2hKIWloLIhpTvpxmLvYvKLy/p/Vc5Ztx0pFH25ML2yvB8wMwS9K8NL2Tb9G2EGpF/oNd3xpub76w==";

		List<Project> projectList1 = new ArrayList<>();

		Projectlist proj = new Projectlist("com.mysql.cj.jdbc.Driver", "jdbc:mysql://localhost:3306/project", "root",
				"1234");

		String result = "";

		try {
			URL url = new URL(
					"https://apis.data.go.kr/6300000/openapi2022/tourspot/gettourspot?serviceKey=DEOJBRmSht2hKIWloLIhpTvpxmLvYvKLy%2Fp%2FVc5Ztx0pFH25ML2yvB8wMwS9K8NL2Tb9G2EGpF%2FoNd3xpub76w%3D%3D&pageNo=1&numOfRows=1000");
			BufferedReader bf;
			bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
			result = bf.readLine();
			System.out.println(result);
			JSONParser paser = new JSONParser();
			JSONObject jsonobj = (JSONObject) paser.parse(result);
			JSONObject response = (JSONObject) jsonobj.get("response");
			JSONObject body = (JSONObject) response.get("body");
			JSONArray items = (JSONArray) body.get("items");

			for (int i = 0; i < items.size(); i++) {

				JSONObject arr = (JSONObject) items.get(i);
				String tourspotNm = (String) arr.get("tourspotNm");
				String tourspotDtlAddr = (String) arr.get("tourspotDtlAddr");
				String refadNo = (String) arr.get("refadNo");
				String mngTime = (String) arr.get("mngTime");
				String tourUtlzAmt = (String) arr.get("tourUtlzAmt");
				String pkgFclt = (String) arr.get("pkgFclt");
				String cnvenFcltGuid = (String) arr.get("cnvenFcltGuid");
				String tourspotSumm = (String) arr.get("tourspotSumm");

				Project p = new Project(i + 1, tourspotNm, tourspotDtlAddr, refadNo, mngTime, tourUtlzAmt, pkgFclt,
						cnvenFcltGuid, tourspotSumm);

				projectList1.add(p);

			}

			for (Project project : projectList1) {
				proj.insertApi(project);
			}
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
