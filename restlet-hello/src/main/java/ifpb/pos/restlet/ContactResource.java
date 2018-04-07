package ifpb.pos.restlet;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class ContactResource extends ServerResource {

//	@Post
//	public Representation addContact(Representation rep){
//		JsonRepresentation jsonrep = new JsonRepresentation(rep);
//		JSONObject json = jsonrep.getJsonObject();
//		String name = json.getString("name");
//	}
	
	@Get
	public Representation getContact() {
		// recuperar o atributo {code}
		String code = (String) getRequestAttributes().get("code");
		// ...
		JSONArray result = new JSONArray();
		try {
			code.toCharArray();
			//
			JSONObject c1 = new JSONObject();
			c1.put("name", "Aristofânio Garcia");
			c1.put("ies", "Faculdade de Juazeiro do Norte");
			c1.put("photo",
					"https://fbcdn-sphotos-h-a.akamaihd.net/hphotos-ak-xap1/v/t1.0-9/1016482_10204008959557435_1807260152938896371_n.jpg?oh=40ddb2933b215ec0f52ebf6c2426633b&oe=54BDE43B&__gda__=1425001218_83c7e6513b5e82a6cbcd7fd24221d1a3");
			result.put(c1);
			//
			JSONObject c2 = new JSONObject();
			c2.put("name", "Yrineu Felipe");
			c2.put("ies", "Faculdade de Juazeiro do Norte");
			c2.put("photo",
					"https://scontent-b-mia.xx.fbcdn.net/hphotos-frc3/v/t1.0-9/575727_518630028232481_233531119_n.jpg?oh=c4840829ca2c1589fd4f9f6bd5fc3be3&oe=54F3BB8E");
			result.put(c2);
			//
			JSONObject c3 = new JSONObject();
			c3.put("name", "Weslly Oliveira");
			c3.put("ies", "Faculdade de Juazeiro do Norte");
			c3.put("photo",
					"https://fbcdn-sphotos-c-a.akamaihd.net/hphotos-ak-xaf1/v/t1.0-9/426941_312745575451353_1087954220_n.jpg?oh=33cebfcb9fc3c2a8b96ec82db90a5145&oe=54BF755F&__gda__=1420535182_130dd158aeca696dab68e50e0546a39e");
			result.put(c3);
			//
		} catch (JSONException e) {
			e.printStackTrace();
		}

		return new JsonRepresentation(result);
	}

}
