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

import static pl.com.redpike.cookbook.data.DataProperties.*;

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
        category.setId(jsonNode.get(CATEGORY_ID_PROPERTY).intValue());
        category.setName(jsonNode.get(CATEGORY_NAME_PROPERTY).textValue());

        Optional.ofNullable(jsonNode.get(CATEGORY_PARENT_ID_PROPERTY)).ifPresent(node -> category.setParentId(node.intValue()));

        Optional.ofNullable(jsonNode.get(CATEGORY_CATEGORY_PHOTO_PROPERTY)).ifPresent(photoBase64String -> {
            byte[] base64 = Base64.getEncoder().encode(photoBase64String.textValue().getBytes());
            category.setCategoryPhoto(base64);
        });

        return category;
    }
}
