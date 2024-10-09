package com.cheezeserver.TestData.Entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cheeses
{
    public List<Cheese> Data;

    public Cheeses()
    {
        /*
         * 
    String Name,
    String Description,
    String Type,
    String Country,
    List<String>  Milk,
    List<String> Texture,
    String Colour,
    String ImagePath)
         */
        Data = new ArrayList<Cheese>();
        Data.add(new Cheese(
            "Alex James Co. No. 4 Goats' Cheese",
            "Alex James Co. No. 4 Goats' cheese is a creamy and fresh cheese. Produced by Alex James Co company using goat's milk, the cheese has a mousse-like texture with a natural acidity.",
            "fresh soft", "United Kingdom", Arrays.asList("goat"), Arrays.asList("smooth", "springy"), "pale white", 23.99, "https://www.cheese.com/media/img/cheese-suggestion/AJCB_No4Goats_1280x800.jpg"));

        Data.add(new Cheese(
            "Darling Blue",
            "Named after the world-famous heroine from the Farne Islands, Doddington Dairy’s Darling Blue is made from pasteurized cow's milk and traditional rennet. This wonderfully mellow, buttery blue cheese features savory, salty notes. With a natural rind, it comes in wheel truckles and is aged for around 2 months. It pairs well with a rich ruby red port and port-soused cranberries and is a must on Christmas cheese boards.",
            "fresh firm", "United Kingdom", Arrays.asList("cow"), Arrays.asList("buttery"), "blue grey", 21.45, "https://www.cheese.com/media/img/cheese-suggestion/Darling_Blue_web.jpg"));

        Data.add(new Cheese(
            "Baby Brie",
            "Brie cheese is a French cheese and is known as \"The Queen of Cheeses\". Baby Brie, Petit Brie, Mini Brie all are the same as the regular Brie, but their diameters are smaller, giving different names. The flavour of these Bries becomes more complex when the surface turns slightly brown. The smell also turns more strong, more salty and hearty.",
            "soft", "France", Arrays.asList("cow"), Arrays.asList("creamy"), "cream", 19.99, "https://www.cheese.com/media/img/cheese/mini_brie.webp"));

        Data.add(new Cheese(
            "Waterloo",
            "Waterloo cheese is made from unpasteurized Guernsey cow's milk and a vegetarian rennet at Village Maid Cheese farm in Riseley, Berkshire. It is a semi-soft cheese produced using the washed curd method. This technique helps to temper the acidity, resulting in a gentle and mellow flavour. The cheese's unique yellow colour is derived from the natural carotene found in the unpasteurized Guernsey milk, sourced exclusively from a single herd of pedigree Guernsey cows.",
            "semi-soft", "England", Arrays.asList("cow"), Arrays.asList("creamy", "firm"), "yellow", 24.99, "https://www.cheese.com/media/img/cheese-suggestion/Waterloo.jpg"));

        Data.add(new Cheese(
            "Smoked Gouda",
            "Gouda, or \"How-da\" as the locals pronounce it, originates from the Dutch city of Gouda. It's a globally adored cheese, constituting 50 to 60 percent of worldwide cheese consumption.",
            "hard", "Netherlands", Arrays.asList("cow", "goat", "sheep"), Arrays.asList("buttery", "crumbly"), "brownish yellow", 26.50, "https://www.cheese.com/media/img/cheese-suggestion/170306-DS-Premium-Cheese-Smoked_381x242_acf_cropped.jpg"));

        Data.add(new Cheese(
            "2 Year Aged Cumin Gouda",
            "Aged for two years, this Gouda cheese is infused with the earthy warmth of cumin seeds, developing a rich texture and bold flavour over time. The inclusion of cumin seeds enhances the richness and depth of taste in this 2 year aged Cumin Gouda.",
            "semi-hard", "Netherlands", Arrays.asList("cow"), Arrays.asList("creamy"), "brownish yellow", 27.00, "https://www.cheese.com/media/img/cheese-suggestion/2_year_aged_Cumin_Gouda.jpg"));

        Data.add(new Cheese(
            "Gammelost",
            "Gammelost, also spelt as Gamalost or Gammalost, is a distinctive Norwegian cheese made from skimmed cow's milk. Since its production is an extremely laborious process, the cheese that was once the staple of a Norwegian diet is today not made in mass quantities. It is extremely rare to find it outside Norway. Like many other Norwegian products, such as flatbread and stockfish, Gammelost can be stored for a long duration without refrigeration.",
            "firm", "Norway", Arrays.asList("cow"), Arrays.asList("grainy", "semi firm"), "brownish yellow", 28.99, "https://www.cheese.com/media/img/cheese/644-gammelost.jpg"));
        
        Data.add(new Cheese(
            "Derby",
            "Derby is a traditional British cheese made in Derbyshire, England, since the 16th century. It is England's oldest and most famous cheese made in several varieties, including Sage Derby. Derby is a semi-hard cheese made from cow's milk. It has a mild flavour and creamy ivory to a rich yellow pate. It is sometimes compared to mild cheddar because of the texture, but Derby is milder with a buttery, creamy flavour and strong melting ability.",
            "semi-firm", "England", Arrays.asList("cow"), Arrays.asList("creamy", "smooth"), "ivory", 15.99, "https://www.cheese.com/media/img/cheese/for_Derby.jpg"));
        
        Data.add(new Cheese(
            "Roaring Forties Blue",
            "Roaring Forties Blue hails from King Island, situated south of Melbourne, Australia. It derives its name from the notorious Roaring 40s westerly winds that sweep along the 40°S longitude. Crafted by the King Island Dairy, Roaring Forties Cheese is a handcrafted blue cheese made from cow's milk. The cheese wheels boast a delightful sweetness and a subtle nutty undertone. To achieve this, the cheese undergoes maturation in a protective wax coating, ensuring moisture retention and resulting in a velvety, creamy texture.",
            "semi-soft", "Australia", Arrays.asList("cow"), Arrays.asList("creamy", "smooth"), "cream", 22.99, "https://www.cheese.com/media/img/cheese/1181-roaring_forties_blue.jpg"));
        
        Data.add(new Cheese(
            "Tibetan Cheeses",
            "Cheeses are an important part of Tibetan cuisine. Tibetans were among the first few Asians to make use of dairy products, but they don't sell novelty cheeses as the Westerners. Most of their cheeses include soft curds resembling cottage cheese is sourced from female yak milk, called \"Dri\". Butter is extracted from the milk of yaks and the remaining buttermilk, called \"dara\" is used for cheese-making.",
            "artisan", "Tibet", Arrays.asList("yak"), Arrays.asList(), "", 12.99, "https://www.cheese.com/media/img/cheese/Tibet.jpg"));
        
        Data.add(new Cheese(
            "Burrata Cheese",
            "Burrata cheese is a luxurious and creamy Italian cheese that has gained popularity in recent years. It is a type of fresh cheese that originates from the Apulia region in Southern Italy. Burrata cheese is made by combining mozzarella cheese and cream, resulting in a unique and luscious texture.",
            "fresh soft", "Italy", Arrays.asList("water buffalo"), Arrays.asList("creamy", "stringy"), "white", 18.50, "https://www.cheese.com/media/img/cheese-suggestion/Burrata.jpg"));
        
        Data.add(new Cheese(
            "Dutch Blue",
            "Dutch Blue (also called Blue de Graven) mould cheese from Holland is a strong, creamy, and delicious cheese made from pasteurized cow's milk. Packaged in the iconic Delft blue colors, it is perfect for a cheese board, sirloin steak, or burger.",
            "fresh soft", "Netherlands", Arrays.asList("cow"), Arrays.asList("creamy"), "blue", 22.50, "https://www.cheese.com/media/img/cheese-suggestion/Dutch_Blue.jpg"));
        
        }
}
