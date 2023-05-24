# Minecraft Recipe Library

A library to modify / read Minecraft Java Edition Recipes

# WARNING
THE CODE IS SHIT, PLEASE FORGIVE ME FOR THE QUALITY OF THIS CODE, IS MY FIRST "LIBRARY" D:
# WARNING

## Recipe Class
### Type
Has 21 possible values:

| Value                                           | Description                                                                                                                             | Example                                             |
|-------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------|
| `minecraft:crafting_shaped`                     | Recipes that need a shape                                                                                                               | Diamond Pickaxe                                     |
| `minecraft:crafting_shapeless`                  | Recipes that *don't* need a shape                                                                                                       | Dying a wool block                                  |
| `minecraft:smelting`                            | Recipes that are made in a Furnace                                                                                                      | Glass                                               |
| `minecraft:blasting`                            | Recipes that are made in a Blast Furnace                                                                                                | Iron Ingot                                          |
| `minecraft:smoking`                             | Recipes that are made in a Smoker                                                                                                       | Cooked Chicken                                      |
| `minecraft:campfire_cooking`                    | Recipes that are made in a Campfire                                                                                                     | Cooked Chicken                                      |
| `minecraft:stonecutting`                        | Recipes that are made in a Stonecutter                                                                                                  | Stone Stairs                                        |
| `minecraft:smithing`                            | Recipes that are made in a Smiting Table                                                                                                | Upgrading a Diamond tool to a Netherite Tool        |
| `minecraft:crafting_special_repairitem`         | Recipe when you repair a tool ***BUT NOT IN AN ANVIL***                                                                                 | Fusing 2 damaged tools in the inventory             |
| `minecraft:crafting_special_mapcloning`         | Recipe when you clone a map ***BUT NOT IN A CARTOGRAPHY TABLE***                                                                        | Empty Map + Ocean Explorer Map                      |
| `minecraft:crafting_special_mapextending`       | Recipe when zooming out maps ***BUT NOT IN A CARTOGRAPHY TABLE***                                                                       | Any filled Map surrounded by paper                  |
| `minecraft:crafting_special_suspiciousstew`     | Recipe when crafting a suspicious stew ([Effect List](https://minecraft.fandom.com/wiki/Suspicious_Stew#Food))                          | Crafting a suspicious stew with a dandelion         |
| `minecraft:crafting_special_firework_star`      | Recipe for Firework Stars that define the Shape Effect ([Shape List](https://minecraft.fandom.com/wiki/Firework_Star#Shape_effects))    | Creating a Firework Star with a Gold Nugget         |
| `minecraft:crafting_special_firework_star_fade` | Recipe for Firework Stars that define the Fade Effect ([Fade List](https://minecraft.fandom.com/wiki/Firework_Star#Additional_effects)) | Creating a Firework Star with a Diamond             |
| `minecraft:crafting_special_firework_rocket`    | Recipe to craft Fireworks with / without Stars                                                                                          | Creating a Firework with or without a Firework Star |
| `minecraft:crafting_special_armordye`           | Recipe to dye Leather Armor                                                                                                             | dying armor                                         |
| `minecraft:crafting_special_bannerduplicate`    | Recipe to clone banners                                                                                                                 | Duplicate Banners                                   |
| `minecraft:crafting_special_bookcloning`        | Recipe to clone Written Books                                                                                                           | Book cloning                                        |
| `minecraft:crafting_special_shielddecoration`   | Recipe to add a banner to a shield                                                                                                      | Adding a banner to a shield                         |
| `minecraft:crafting_special_shulkerboxcoloring` | Recipe to dye Shulker Boxes                                                                                                             | Dying a Shulker Box red                             |
| `minecraft:crafting_special_tippedarrow`        | Recipe to craft tipped arrows to keep the potion effects                                                                                | Speed Lingering Potion surrounded by arrows         |
