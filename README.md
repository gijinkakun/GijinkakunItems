# GijinkakunItems Plugin

GijinkakunItems is a Bukkit/Spigot plugin that introduces a variety of unique and powerful items with special abilities into the game. Players can obtain these items through commands and use their abilities to enhance their gameplay experience.

## Features

- **Special Items**: Adds unique items such as Mythrilbreaker, Earthshaper, Timbercleaver, Shroom Blade, Chicken Shooter, Inferno Bow, Tidecaller Bow, Arcane Detonator, Stormstriker, String of Sacrifice, Tempest Scythe, Verdant Purifier, Amethyrite Edge, and Bloodrender.
- **Custom Abilities**: Each item comes with its own special abilities and effects.
- **Item Voting System**: Players can vote to change certain game conditions using special items.
- **Prevent Item Modification**: Special items cannot be modified in anvils, enchanting tables, grindstones, smithing tables, stonecutters, or crafting tables.
- **Real-time Updates**: Players receive real-time updates on their actions and abilities via chat messages.

## Commands

### `/gijinkakunitems give <item> <playername> <amount>`

Gives a specified amount of a special item to a player.

- **Usage:** `/gijinkakunitems give <item> <playername> <amount>`
- **Permission:** This command can only be run by server operators.

## Permissions

- `gijinkakunitems.give`: Allows the use of the `/gijinkakunitems give` command.

## Configuration

The plugin does not require any specific configuration files. All functionality is controlled through commands and in-game interactions.

## Installation

1. Download the plugin JAR file and place it in your server's `plugins` directory.
2. Start your server to load the plugin.
3. Use the `/gijinkakunitems give <item> <playername> <amount>` command to start giving out special items!

## Building the Plugin

If you want to build the plugin from source, follow these steps:

1. Clone the repository.
2. Ensure you have Maven installed.
3. Run `mvn clean install` to build the plugin.
4. The compiled JAR file will be located in the `target` directory.

## Special Items and Abilities

- **Mythrilbreaker**: A powerful pickaxe with enhanced mining capabilities.
- **Earthshaper**: A shovel that can mold the land with a single stroke.
- **Timbercleaver**: An axe that can fell entire forests in one swing.
- **Shroom Blade**: A revered tool crafted from Heartwood.
- **Chicken Shooter**: A whimsical bow that spawns chickens.
- **Inferno Bow**: A bow that harnesses the raw fury of molten lava.
- **Tidecaller Bow**: A bow that channels the essence of the ocean.
- **Arcane Detonator**: A bow with the essence of controlled chaos.
- **Stormstriker**: A bow that unleashes lightning with every arrow.
- **String of Sacrifice**: Keeps you safe from the void.
- **Tempest Scythe**: Unleashes whirlwinds with each swing.
- **Verdant Purifier**: Transforms and purifies blocks.
- **Amethyrite Edge**: A netherite pickaxe with unique abilities.
- **Bloodrender**: A golden axe that severs heads with a single swing.

## Event Listeners

- **EntityDamageEventListener**: Handles custom item abilities during entity damage events.
- **InventoryClickEventListener**: Prevents modification of special items in various inventories.
- **PlayerDeathEventListener**: Handles custom item effects on player death.
- **PlayerInteractEventListener**: Handles custom item interactions.
- **PlayerJoinEventListener**: Updates special items in player inventories on join.
- **PlayerMoveEventListener**: Handles custom item effects during player movement.
- **ProjectileHitEventListener**: Handles custom projectile abilities.
- **BlockBreakEventListener**: Handles custom item effects on block break.
- **EntityDeathEventListener**: Handles custom item effects on entity death.

## Dependencies

- No external dependencies are required for this plugin.

## Troubleshooting

- Ensure that the plugin is correctly placed in the `plugins` directory and the server is restarted.
- Verify that the required commands are being typed correctly by players.
- Check the server console for any error messages related to the plugin.

## License

This project is licensed under the GNU General Public License v3.0. See the [LICENSE](LICENSE) file for details.

## Contributing

Contributions are welcome! Please fork the repository and submit a pull request with your changes.

## Contact

For any questions or support, feel free to open an issue on the GitHub repository.
