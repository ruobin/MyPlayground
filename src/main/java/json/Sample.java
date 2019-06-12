package json;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class Sample {

    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper(); // create once, reuse

//        json.MyValue value = mapper.readValue(new File("data.json"), json.MyValue.class);
// or:
//        json.MyValue value = mapper.readValue(new URL("http://some.com/api/entry.json"), json.MyValue.class);
// or:
        MyValue value = mapper.readValue("{\"name\":\"Bob\", \"age\":13}", MyValue.class);
    }
}
