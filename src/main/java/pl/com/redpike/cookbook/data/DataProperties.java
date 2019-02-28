package pl.com.redpike.cookbook.data;

public class DataProperties {

    private DataProperties() {
    }

    /**
     * CATEGORY TABLE
     */
    public static final String CATEGORY_TABLE = "category";

    public static final String CATEGORY_ID_COLUMN = "id";
    public static final String CATEGORY_NAME_COLUMN = "name";
    public static final String CATEGORY_CATEGORY_PHOTO_COLUMN = "category_photo";
    public static final String CATEGORY_PARENT_COLUMN = "parent";

    public static final String CATEGORY_ID_PROPERTY = "id";
    public static final String CATEGORY_NAME_PROPERTY = "name";
    public static final String CATEGORY_CATEGORY_PHOTO_PROPERTY = "categoryPhoto";
    public static final String CATEGORY_PARENT_ID_PROPERTY = "parentId";

    /**
     * RECIPE TABLE
     */
    public static final String RECIPE_TABLE = "recipe";

    public static final String RECIPE_ID_COLUMN = "id";
    public static final String RECIPE_NAME_COLUMN = "name";
    public static final String RECIPE_RECIPE_PHOTO_COLUMN = "recipe_photo";
    public static final String RECIPE_RECIPE_ID_COLUMN = "recipe_id";
    public static final String RECIPE_CATEGORY_COLUMN = "category";

    /**
     * RECIPE INGREDIENT TABLE
     */
    public static final String RECIPE_INGREDIENT_TABLE = "recipe_ingredient";

    public static final String RECIPE_INGREDIENT_ID_COLUMN = "id";
    public static final String RECIPE_INGREDIENT_BODY_COLUMN = "body";

    /**
     * RECIPE STEP TABLE
     */
    public static final String RECIPE_STEP_TABLE = "recipe_step";

    public static final String RECIPE_STEP_ID_COLUMN = "id";
    public static final String RECIPE_STEP_BODY_COLUMN = "body";
}
