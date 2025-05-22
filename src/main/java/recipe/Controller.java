import java.util.List;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {
    @Autowired
    private RecipeService recipeService;

    @PostMapping("/search")
    public List<Recipe> getRecipes(@RequestBody List<String> ingredients) {
        return recipeService.findRecipesByIngredients(ingredients);
    }
}
