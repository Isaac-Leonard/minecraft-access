# Minecraft Access

Minecraft Access is a replacement of the other accessibility [mods.](https://github.com/accessible-minecraft) Just like
the previous mods, this mod also supports screen readers for windows, but now it also supports additional screen readers
thanks to [tolk](https://github.com/ndarilek/tolk) library. Additionally, the mod also supports linux using
the [libspeechdwrapper](https://github.com/khanshoaib3/libspeechdwrapper).

*Note that you may have to enable the narrator from within minecraft, in the first sartup, the mod speaks "Initializing minecraft access" but does not speak anything else, then you'll have to use `control + b` to enable the narrator. And for fabric users, you will have to manually un-bound or re-bound the advancement key from l to something else as that is also used by the camera controls feature.*

# Setup

There is [a new detailed tutorial](/doc/SET_UP_ON_WINDOWS.md) for Windows users.

## Requirements

1. The mod works with both forge and fabric, so you need to install either one of those. For forge, you can
   follow [this](https://thebreakdown.xyz/how-to-download-install-forge-to-play-minecraft-mods/) guide and for fabric.
   you can follow [this](https://thebreakdown.xyz/how-to-download-install-the-fabric-mod-loader/) guide.
2. We also need to install the [architectury api](https://www.curseforge.com/minecraft/mc-mods/architectury-api) mod.
3. Windows specific
    1. In windows we need to install the [tolk](https://github.com/ndarilek/tolk) library.
       We've implemented the automatic set-up process inside the mod, it will set up the tolk for you at the first time you starting the modded game.
       Here are the steps to install the library in case you need to adjust the tolk files manually:
        1. Download the latest build
           zip - [here](https://github.com/ndarilek/tolk/releases/download/refs%2Fheads%2Fmaster/tolk.zip).
        2. Extract the downloaded zip file anywhere you like, the Downloads folder should be fine.
        3. Open the extracted folder and in that folder you'll find a folder called `x64` and another called `x86`.
        4. Based on your operating system, `x64` for 64-bit OS and `x86` for 32-bit OS, copy all the files present in the
           folder and paste them into the minecraft root folder (the folder containing the mods folder).
           The default location is `%appdata%\.minecraft`.
4. Linux specific
   In linux we need to install the [libspeechdwrapper](https://github.com/khanshoaib3/libspeechdwrapper) as well
   as [xdotool](https://github.com/jordansissel/xdotool) which is used for simulating the mouse actions.
   Although the mod overrides the library used for TTS, minecraft still needs the `flite` library to be installed, so
   you can install it using your distro's package manager itself.
   For libspeechdwrapper, download the
   library - [here](https://github.com/khanshoaib3/libspeechdwrapper/raw/main/lib/libspeechdwrapper.so),
   and move it over to the minecraft folder.
   The default location is `~/.minecraft`.
   Follow the [installation instruction](https://github.com/jordansissel/xdotool#installation) in the description to
   install xdotool.

## Mod Installation

- Download the mod file according to the loader installed from
  the latest release page - [here](https://github.com/khanshoaib3/minecraft-access/releases).
- Move the downloaded jar file over to the mods folder.
  For windows the default location is - `%appdata%\.minecraft\mods`
  And for linux it is - `~/.minecraft/mods`

# Features

## Camera Controls

This feature adds the following key bindings to control the camera through the keyboard.

### Keybindings and Combinations

1. Look Up Key (default: I) or Alternate Look Up Key(default: Keypad 8) = Moves the camera vertically up by the normal
   rotating angle (default=22.5).
2. Look Right Key (default: L) or Alternate Look Right Key(default: Keypad 6) = Moves the camera vertically right by the
   normal rotating angle (default=22.5).
3. Look Down Key (default: K) or Alternate Look Down Key(default: Keypad 2) = Moves the camera vertically down by the
   normal rotating angle (default=22.5).
4. Look Left Key (default: J) or Alternate Look Up Key(default: Keypad 4) = Moves the camera vertically left by the
   normal rotating angle (default=22.5).
5. Left Alt + Look Up Key = Moves the camera vertically up by the modified rotating angle (default=11.25).
6. Left Alt + Look Right Key = Moves the camera vertically right by the modified rotating angle (default=11.25).
7. Left Alt + Look Down Key = Moves the camera vertically down by the modified rotating angle (default=11.25).
8. Left Alt + Look Left Key = Moves the camera vertically left by the modified rotating angle (default=11.25).
9. Right Alt + Look Up Key or Look North Key (default: Keypad 7) = Snaps the camera to the north block.
10. Right Alt + Look Right Key or Look East Key (default: Keypad 9) = Snaps the camera to the east block.
11. Right Alt + Look Down Key or Look South Key (default: Keypad 3) = Snaps the camera to the south block.
12. Right Alt + Look Left Key or Look West Key (default: Keypad 1) = Snaps the camera to the west block.
13. Right Alt + double Look Up Key or Look Straight Up Key (default: Keypad 0): Snaps the camera to the look above head direction.
14. Right Alt + double Look Down Key or Look Straight Down Key (default: Keypad `.` (decimal, dot)): Snaps the camera to the look down at feet direction.
15. Center Camera (default: Keypad 5) = Snaps the camera to the closest cardinal direction and centers it.
16. Left Alt + Center Camera = Snaps the camera to the closest opposite cardinal direction and centers it.

### Configuration Options

1. Enabled = Enables this feature.
2. Normal Rotating Angle = The rotation angle when we press the keys without holding down the left alt
   key.
3. Modified Rotating Angle = The rotation angle when we press the keys while holding down the left alt
   key.
4. Delay = Pauses the execution of this feature after each cycle for the given amount of milliseconds.

## Inventory Controls

This features lets us use keyboard in inventory screens. Works with all default minecraft screens.
Please note that item speaking in "Scrollable Recipes Group" under "Crafting Screen" will be delayed about one second,
wait after press the slot moving key to hear the item name.

*All key binds are re-mappable(except two keys) from the game's controls menu and these key binds do not interrupt with
any other key with same key.*

### Keybindings and Combinations

1. Up Key (default: I) = Focus to slot above.
2. Right Key (default: L) = Focus to slot right.
3. Down Key (default: K) = Focus to slot down.
4. Left Mouse Click Sim Key (default: `[` (left bracket)) = Simulates left mouse click, picking up and putting down all items in the slot.
5. Right Mouse Click Sim Key (default: `]` (right bracket)) = Simulates right mouse click, picking up half of the items or putting one item down.
6. Left Key (default: J) = Focus to slot left.
7. Group Key (default: C) = Select next group.
8. Left Shift + Group Key = Select previous group.
9. Switch Tab Key (default: V) = Select next tab (only for creative inventory screen and inventory/crafting screen).
10. Left Shift + Switch Tab Key = Select previous tab (only for creative inventory screen and inventory/crafting screen).
11. Toggle Craftable Key (default: R) = Toggle between show all and show only craftable recipes in inventory/crafting screen.
12. Left Shift + Up Key = Select previous page of the Recipe Book. (active when recipe book group is selected).
13. Left Shift + Down Key = Select next page of the Recipe Book. (active when recipe book group is selected).
14. T Key (not re-mappable) = Select the search box.
15. Enter Key (not re-mappable) = Deselect the search box.

### Configuration Options

1. Enabled = Enables this feature.
2. Auto Open Recipe Book (in creative/survival and crafting inventory) = Automatically opens the recipe
   book on opening the inventory.
3. Row and Column Format in Crafting Input Slots = The speaking format of row and column, the first %d
   is for row and second %d is for column.
4. Delay (in milliseconds) = Pauses the execution of this feature after each cycle for the given amount of milliseconds.

## Mouse Simulation

When you are playing with this mod, most of the time your dominant hand will be fixed on the keyboard instead of the mouse.
This feature provides customizable keys to simulate mouse operations with the keyboard keys for your convenience.

Please note that:

* The keys in this feature only work when there is no screen open.
* You need to keep the `Attack/Destroy` key, `Use Item/Place Block` key and `Pick Block` key remain on default mouse keys,
  so the mouse simulation keys can perform corresponding operations.

### Keybindings and Combinations

1. Left Mouse Sim Key (default: `[` (left bracket)) = Simulates left mouse key, the default `Attack/Destroy` key.
2. Middle Mouse Sim Key (default: `\` (back slash)) = Simulates middle mouse key, the default `Pick Block` key.
3. Right Mouse Sim Key (default: `]` (right bracket)) = Simulates right mouse key, the default `Use Item/Place Block` key.
4. Mouse Wheel Scroll Up Key (default: `;` (semicolon)) = Simulates mouse wheel scroll up, switching items in Hotbar forward.
5. Mouse Wheel Scroll Down Key (default: `'` (apostrophe, prime, single quote)) = Simulates mouse wheel scroll down, switching items in Hotbar backward.

### Configuration Options

1. Enabled = Enables this feature.
2. Scroll Delay (in milliseconds) = Pauses the execution of mouse scroll operations after each scroll for the given amount of milliseconds.

## Read Crosshair

This feature reads the name of the targeted block, entity or fluid. It also gives feedback when a block is powered by a
redstone signal or when a door is open and other similar cases.

### Configuration Options

1. Enabled = Enables this feature.
2. Speak Block Sides = Enables speaking of the side of block as well.
3. Disable Speaking Consecutive Blocks With Same Name = Disables speaking the block if the previous block was also same.
4. Repeat Speaking Interval (in milliseconds) = Repeat speaking the block you are facing for the given amount of time, even you haven't moved the camera.
   Zero for tuning it off, default: 5000.
5. Enable Partial Speaking = Let the mod only speak entities/blocks that you've configured.
6. Partial Speaking White List Mode = If true, only speak what you've configured, if false for blacklist mode, only not spak what you've configured.
7. Partial Speaking Fuzzy Mode = Whether to do fuzzy matching, for example "bed" will match all colors of beds, "door" will match all textures of doors.
8. Partial Speaking Target Mode = Which type would you like to apply this feature to, either "all", "entity" or "block".
   This configuration can only be configured in config.json file.
9. Partial Speaking Targets = Indicated what to be spoken.
   This configuration can only be configured in config.json file.
   Values are written in Minecraft resource location format,
   the so-called "snake_case", and consists of lowercase letters with underscores.
   For example, the White Bed is written in "white_bed" and pronounced as "white underscore bed".
   There are lots of exceptions, the "Smooth Quartz Block" is written in "smooth_quartz", the "Block of Diamond" is written in "diamond_block",
   so please check the correct values in this wiki link:
   https://minecraft.fandom.com/wiki/Java_Edition_data_values#Blocks

## Position Narrator

Adds key bindings to speak the player's position.

### Keybindings and Combinations

1. Speak Player Position Key (default: G) = Speaks the player's x y and z position.
2. Left Alt + X = Speaks only the x position.
3. Left Alt + C = Speaks only the y position.
4. Left Alt + Z = Speaks only the z position.

## Points of Interest

This feature scans the area for entities, ore blocks, doors, levers, etc. and plays a sound at their position (only for
entities and ore blocks).
We can lock onto the closest entity or block with a hotkey.
We can also "mark" a block/entity so that it only scans for that type of block/entity in the area.

### Keybindings and Combinations

1. Locking Key (default: Y) = Locks onto the nearest entity or block.
2. Alt key + Locking Key = Unlocks from the currently locked entity or block.
3. Control Key + Locking Key = Mark the crosshair block/entity.
4. Control Key + Alt key + Locking Key = Unmark the marked block/entity.

### Configuration Options

1. For Blocks
    - Enabled = Enables detecting blocks.
    - Detect Fluid Blocks = Enables detecting fluids.
    - Range = The detection range.
    - Play Sound = Enables playing a sound at ore blocks
    - Sound Volume = The volume of the sound.
    - Play Sound for Other Blocks as well = Enables playing sound for other interactive blocks
    - Delay (in milliseconds) = Pauses the execution of this feature after each cycle for the given amount of
      milliseconds.
2. For Entities
    - Enabled = Enables detecting entities.
    - Range = The detection range.
    - Play Sound = Enables playing a sound at entities
    - Sound Volume = The volume of the sound.
    - Delay (in milliseconds) = Pauses the execution of this feature after each cycle for the given amount of
      milliseconds.
3. For Entities/Blocks Locking
    - Enabled = Enables the locking feature.
    - Lock on Blocks = Enables locking on to the closest block,
    - Speak Relative Distance to Entity/Block = Speaks the distance to the entity/block on locking.
    - Play Unlocking Sound = Enables playing a sound on unlock.
    - Auto Lock on to Eye of Ender when Used = Enables locking onto the eye of ender when it's used/thrown.
    - Delay (in milliseconds) = Pauses the execution of this feature after each cycle for the given amount of
      milliseconds.

## Narrator Menu

A menu that opens up when we press `F4` button.

### Options included in this menu

1. Block and fluid target information = Speaks the name and information of the targeted block. The range is much more
   than normal crosshair target.
2. Block and fluid target position = Speaks the name and position of the targeted block. The range is much more than
   normal crosshair target.
3. Light level = Speaks the light level at the player's current position.
4. Find water = Finds the closest water source block.
5. Find lava = Finds the closest lava source block.
6. Biome = Speaks the name of biome the player is currently in.
7. Time of Day = Speaks the current time of day.
8. XP = Speaks the experience level and progress of the player.
9. Refresh screen Reader = Refreshes the screen reader.
10. Open config menu = Opens the config menu which can be used to configure the mod.

### Keybindings and Combinations

1. Narrator Menu Function Hot Key (default: B) = Holding `F4` then press this key to loop switch between functions in Narrator Menu,
   then press this single key for executing selected function.
2. When Narrator Menu is opened, press the number key corresponding to the function to execute it,
   without pressing `Tab` several times.

### Configuration Options

1. For Find Water and Find Lava, or Fluid Detector:
    - Range = The detection range.
    - Sound Volume = The volume of the sound.

## Health n Hunger

Adds a key bind to narrate/speak the player's health and hunger.

- Speak Player Health and Hunger Key (default: R) = Speaks the health and hunger.

## Player Warnings

This feature warns the player when the health, hunger or air bubble is low.

### Configuration Options

1. Enabled = Enables this feature.
2. Play Sound = Enables playing a sound when the health/hunger/air reaches the threshold.
3. Health Threshold First = The first health threshold.
4. Health Threshold Second = The seconds health threshold.
5. Hunger Threshold = The threshold for hunger/food.
6. Air Threshold = The threshold for air when submerged in water.

## Facing Direction

Adds key binding to speak the player's facing direction.

- Speak Facing Direction Key (default: H) = Speaks the player facing direction.

## Biome Indicator

Narrates the name of the biome when entering a different biome.

## XP Indicator

Narrates when the player xp level is increased or decreased.

## Durability Indicator

Adds the item durability into the tooltip.

## Fall Detector

Check the surrounding height difference and warn the user with a drop sound effect at the corresponding position.

### Configuration Options

1. Enabled = Enables this feature.
2. Range = The player-centered detection range.
3. Depth Threshold = The threshold for playing the sound effect.
4. Sound Volume = The volume of the sound.
5. Delay (in milliseconds) = Pauses the execution of this feature after each cycle for the given amount of
   milliseconds.

## Book Editing

Press Use key while holding a [Book and Quill](https://minecraft.fandom.com/wiki/Book_and_Quill) item to open the book editing screen.
Press Tab key to select buttons, while button is focused, press Space key or Left Mouse key to click it (space can be inputted as text when no button is focused).
Press Page Up and Page Down Key to switch between pages.
Press "Done" button to save your unfinished work and quit editing screen.
Press "Sign" button and enter a title for the book to make it permanently non-editable.

# Mod Configuration

The mod can be configured in two ways: using the config menu or directly editing the config.json file.
The config menu can be opened via the `Open Config Menu` option in the Narrator/F4 Menu.
Currently, we do not have a command to open the config menu so don't disable the narrator menu or you won't be able to open the config menu.
As for the other method, the config.json file can be found in the `config/minecraft_access/` directory.
You can use notepad or any text editor to edit the file. You can also use online json editor like
[Json Editor Online](https://jsoneditoronline.org/), [Json Formatter](https://jsonformatter.org/json-editor)
or [Code Beautify Json Online Editor](https://jsonformatter.org/json-editor).

# Known Issues

1. The default narrator speaks even if the narrator is turned off.
2. In "Scrollable Recipes Group" under "Crafting Screen", except the first page, sometimes you will hear nothing while you moving between slots.
   It's best to keep items you want to craft within the first page of the recipe book by moving unused resource items out of your inventory.
3. (Linux only) xdotool is not recognised even if it is installed.
4. (Linux only) Minecraft says not narrator available even if flite is installed.
