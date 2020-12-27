# Fett.lol Util Mod

This mod adds a number of minor tweaks that were desired on the `fett.lol` Minecraft server. Some
of these are inspired by other mods, where we just wanted a small portion of what that mod did and
did not want to install the entire mod. Others are completely novel and are of our own creation. 
Another couple are recreations of mods that have been lost to the sands of time as Minecraft
continued to be updated while the mod was not.

Note that this mod does not currently have any configuration associated with it. In future
updates, we will be adding the possibility to turn each of these tweaks on or off.

## The List of Implemented Tweaks

- **Villagers follow players holding Emerald Blocks** Just like sheep, cows, chicken and other animals will follow the
  food that they love most, villagers will also follow what it is they love most; Emeralds. However, not just any
  old emerald will do, we have to entice them with an entire Emerald Block! Also, given that they're not animals, 
  villagers can be a bit skittish and often lose their concentration, so don't run too far ahead of them!
- **Disable the "Custom Worlds" warning that just isn't any fun any more.**
- **Bows with "Infinity" enchant do not require an arrow in the inventory.**
- **Poisoned Potatoes can be composted**
- **Feather Falling ensures you cannot trample farmland and crops.**
- **Chickens randomly drop feathers.**
- **Automatically unlock all available recipes when you log in.**

## Tweak(s) Currently Being Worked On
  
## The List of Future Tweaks

- **Dropped Items and XP Orbs merge faster and over slightly greater distances**.

- **Soul Fire does not destroy items dropped in it like normal fire does**. The logic here is that Soul Fire is "colder"
  and thus does not destroy items. If possible, maybe limit this to metal items only, so that things like paper and
  wood continue to be destroyed - not sure how easy this would be to implement, however.
  
- **Command to find Nether Equivalent and vice versa**. Basically, typing `/eqcoords` or similar would inform you of the
  equivalent coordinates in the other dimension. Standing at 1840, 65, -1223 in the overworld and typing this command
  should return simply `230, 65, -154`, as it rounds the response to the nearest whole number.
  - Possibly integrate this with mapping and waypoint mods to allow players to add a waypoint to the area in question
    so that the workflow makes more sense.  

- **"Refresh" the enchantments on offer for a price.** Not sure if this price should be XP, Lapis or something else.

- **Remove the "Too Expensive" the limitation on repairs and enchanting.** Instead, there should just be a max price 
  that one eventually reaches and which just continues to be the max price.
  
- **Universal dyes - allow recoloring of colored Wool and Terracotta, not just white Wool and "plain" Terracotta.**
  - Possibly add the ability to re-dye Concrete Powder as well, but not the "hardened" Concrete.
  - Can this be done programmatically or do I have to do it using recipes in something more like a datapack format?
  - Simplest idea is most likely to do this via item tags. Need to check if there's a commonly agreed upon set of tags
    that people already use for this kind of thing. Maybe Cotton has something?
        
- **Introduce the ability to "pulverize" concrete to get it back into its dust form.** I do not like the method I have
  seen in some mods where concrete hit by a falling anvil turns into powder, some other method would be preferrable.

- **Skeletons hit by lightning can turn into Wither Skeletons.**

- **Introduce a set of colored blocks that slime does not stick to.** This would be a block that can be used inside of
  flying machine-based farms etc that removes the need to build them with Furnaces, Glazed Terracotta or leaves. I'm
  thinking something more like being able to coat concrete blocks with honey, giving a more 'glossy' version of the
  concrete block? This could be useful in building as well.

- **Allow Infinity and Mending to co-exist?** This is pretty unbalanced, of course, and maybe some kind of penalty needs
  to be added to bows if both of these things exist at the same time, but I'm not sure what that penalty could be.
  Increased draw time? Reduced damage?

- *... and more.*

## Thanks and Credits

This mod would not have been possible without the inspiration and previous work done by the following people and the
following projects:

- Module and Config handling strongly inspired by the [Charm](https://github.com/svenhjol/Charm) project maintained by
  fellow Icelander `svenhjol`.
- "Chickens Drop Feathers" code also from the Charm project.
