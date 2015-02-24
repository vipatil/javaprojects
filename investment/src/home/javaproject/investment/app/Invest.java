package home.javaproject.investment.app;

import home.javaproject.investment.pojo.Investment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;


public class Invest {

	public static void main(String[] args) {
		
		Portfolio pl = new Portfolio();
		pl.init("idata.xml");		
		List<Investment> il = pl.getList();

		for(Investment sr: il) {
			try {
				String value = getRequest(sr.getSymbol());
				System.out.println(sr.getSymbol()+ " : " + value);
			} catch (IllegalStateException | IOException e) {

				e.printStackTrace();
			}
			catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	private static String getRequest(String stock) throws IllegalStateException, IOException {

		HttpClient client = new DefaultHttpClient();
		String url = "http://finance.google.com/finance/info?client=ig&q=INDEXBOM:";
		//String url = "http://finance.google.com/finance/info?client=ig&q=SENSEXBOM:";
		url+=stock;
		HttpGet get = new HttpGet(url);

		HttpResponse response = client.execute(get);

		BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}

		String jasonStr = result.toString();
		jasonStr = jasonStr.replace("//", " ");
		jasonStr = jasonStr.replace("[", " ");
		jasonStr = jasonStr.replace("]", " ");
		jasonStr = jasonStr.trim();

		JSONObject o = new JSONObject(jasonStr);

		String currVal = o.getString("l_cur");

		return currVal;
	}

}
