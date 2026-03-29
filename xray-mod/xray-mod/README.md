# X-Ray Mod — Fabric 1.21.1

## Fonctionnement
- **Alt Gauche** → Ouvre le panneau X-Ray
- Clique sur **"X-Ray: OFF"** pour activer → devient **"X-Ray: ON"**
- Les blocs normaux deviennent transparents, seuls les minerais restent visibles

## Minerais visibles
Diamant, Fer, Or, Émeraude, Lapis, Redstone, Charbon, Cuivre, Ancient Debris,
Nether Gold, Quartz, + Coffres et Spawners

---

## Comment compiler (générer le .jar)

### Pré-requis
1. **JDK 21** → https://adoptium.net/
2. **IntelliJ IDEA** (recommandé) → https://www.jetbrains.com/idea/

### Étapes

1. **Ouvre le dossier** `xray-mod` dans IntelliJ IDEA
   - File → Open → sélectionne le dossier

2. **Attends** que Gradle télécharge les dépendances (peut prendre 5-10 min la première fois)

3. **Compile** en ouvrant le terminal dans IntelliJ et tape :
   ```
   ./gradlew build
   ```
   Sur Windows :
   ```
   gradlew.bat build
   ```

4. **Trouve ton .jar** dans :
   ```
   build/libs/xray-mod-1.0.0.jar
   ```

5. **Installe le mod** :
   - Copie le `.jar` dans ton dossier `mods/` de Minecraft
   - (généralement `%appdata%\.minecraft\mods` sur Windows)

---

## Notes
- Ce mod est **client-side uniquement**
- Utilise uniquement sur des serveurs où c'est autorisé
