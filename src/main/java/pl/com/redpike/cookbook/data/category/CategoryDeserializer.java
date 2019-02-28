package pl.com.redpike.cookbook.data.category;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;
import java.util.Base64;
import java.util.Optional;

@JsonComponent
public class CategoryDeserializer extends JsonDeserializer<Category> {

    @Override
    public Category deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        JsonNode jsonNode = jsonParser.getCodec().readTree(jsonParser);
        Category category = new Category();
        category = deserializeCategory(jsonNode, category);

        return category;
    }

    private Category deserializeCategory(JsonNode jsonNode, Category category) {
        category.setId(jsonNode.get("id").intValue());
        category.setName(jsonNode.get("name").textValue());

        Optional.ofNullable(jsonNode.get("parentId")).ifPresent(node -> category.setParentId(node.intValue()));

        Optional.ofNullable(jsonNode.get("categoryPhoto")).ifPresent(photoBase64String -> {
            byte[] base64 = Base64.getEncoder().encode(photoBase64String.textValue().getBytes());
            category.setCategoryPhoto(base64);
        });

        return category;
    }
}
