import java.util.List;

@Service
public class RecipeService {
    @Autowired
    private RecipeRepository recipeRepository;

    public List<Recipe> findRecipesByIngredients(List<String> ingredients) {
        // レシピ検索のロジック（食材が含まれているレシピを検索）
        return recipeRepository.findRecipes(ingredients);
    }
}