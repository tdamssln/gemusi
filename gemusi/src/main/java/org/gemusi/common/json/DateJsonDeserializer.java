package org.gemusi.common.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DateJsonDeserializer extends JsonDeserializer<Date> {
	public static final SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
	@Override
	public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
		try {
			return format.parse(jsonParser.getText());
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
}
