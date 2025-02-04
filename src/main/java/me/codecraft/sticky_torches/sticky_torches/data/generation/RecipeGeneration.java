package me.codecraft.sticky_torches.sticky_torches.data.generation;

import me.codecraft.sticky_torches.sticky_torches.item.StickyTorchesItemsRegistry;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeBookCategory;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class RecipeGeneration extends FabricRecipeProvider {
    public RecipeGeneration(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }
    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {

        RecipeGenerator recipeGenerator  = new RecipeGenerator(wrapperLookup, recipeExporter) {

        @Override
        public void generate() {

            createShaped(RecipeCategory.TOOLS,StickyTorchesItemsRegistry.STICKY_TORCH).input('#', () -> Items.TORCH).input('s',() ->
                    Items.SLIME_BALL).pattern("#").pattern("s")
                    .criterion(hasItem(Items.TORCH), conditionsFromItem(Items.TORCH))
                    .criterion(hasItem(Items.SLIME_BALL), this.conditionsFromItem(Items.SLIME_BALL))
                    .offerTo(this.exporter);



            createShaped(RecipeCategory.TOOLS,StickyTorchesItemsRegistry.SOUL_STICKY_TORCH).input('#', () -> Items.SOUL_TORCH).input('s',() ->
                            Items.SLIME_BALL).pattern("#").pattern("s")
                    .criterion(hasItem(Items.SOUL_TORCH), this.conditionsFromItem(Items.SOUL_TORCH))
                    .criterion(hasItem(Items.SLIME_BALL), this.conditionsFromItem(Items.SLIME_BALL))
                    .offerTo(this.exporter);

        }};

        return recipeGenerator;
    }

    @Override
    public String getName() {
        return "Recipe Generation";
    }
}
