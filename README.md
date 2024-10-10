# D&D 5e API in Java

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

A RESTful API designed for accessing data from Dungeons & Dragons 5th Edition.

This API allows you to retrieve detailed information about armors, concepts, containers, equipment packs, items, skills, spells, and weapons.

## Table of Contents

- [Installation](#installation)
- [Usage](#usage)
- [Configuration](#configuration)
- [License](#license)
- [Contributing](#contributing)

## Installation

1. Clone the repository:
    ```bash
    git clone https://github.com/kwisek/5e-api.git
    ```

2. Install dependencies and build the project:
    ```bash
    ./mvnw clean install
    ```

3. Run the server *(define your own profile if you want to go beyond provided LOCAL configuration)*:
    ```bash
    ./mvnw spring-boot:run -Dspring-boot.run.profiles=LOCAL
    ```

## Usage

### Example Request
To retrieve information about a spell such as Bigby's Hand:
```bash
curl -X GET "http://localhost:8080/v1/closest/details?name=bigbys hand"
```

```json
{
  "index": "spell-bigbys-hand",
  "category": "Spell",
  "subCategory": "Evocation Spell",
  "name": "Bigby's Hand",
  "source": "Player's Handbook",
  "components": {
    "verbal": true,
    "somatic": true,
    "material": "An eggshell and a snakeskin glove"
  },
  "level": 5,
  "range": "120 feet",
  "school": "Evocation",
  "duration": "Concentration, up to 1 minute",
  "ritual": false,
  "castingTime": "1 action",
  "classes": [
    "Artificer",
    "Sorcerer",
    "Wizard"
  ],
  "higherLevel": "When you cast this spell using a spell slot of 6th level or higher, the damage from the clenched fist option increases by 2d8 and the damage from the grasping hand increases by 2d6 for each slot level above 5th.",
  "description": [
    "You create a Large hand of shimmering, translucent force in an unoccupied space that you can see within range.",
    "The hand lasts for the spell's duration, and it moves at your command, mimicking the movements of your own hand."
  ]
}
```

## Configuration
This project is ready to roll, but you’ll need to provide your own database and configure repositories accordingly.

- Note: **The database is not provided**.
- Only configuration for the LOCAL profile is included in this repo, and it is prepared to connect to SQLite.

## License
MIT License, have fun! 🎲

## Contributing
Contributions are not expected, as this API is designed to support a private group of nerdy friends for D&D games. However, if you'd like to contribute, feel free! Please create an issue first though.