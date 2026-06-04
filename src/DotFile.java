import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class DotFile {

    public StringBuilder content;

    public DotFile(String graphName) {
        this.content = new StringBuilder();
        content.append("digraph ").append(graphName).append(" {").append("\n");
        content.append("rankdir=LR;").append("\n");
    }

    public void addPokemon(Pokemon pokemon, int index) {
        var pokemonLabel = getPokemonLabel(pokemon);
        var pokemonNode = new DotFileNode(pokemon.name + "_" + index, pokemonLabel);
        pokemonNode.addAttributeWithQuotes("image", getPokemonImagePath(pokemon));
        pokemonNode.addAttribute("style", "filled");
        pokemonNode.addAttribute("fillcolor", "lightblue");
        pokemonNode.addAttribute("shape", "box");
        addLine(pokemonNode.toString());
    }

    private String getPokemonImagePath(Pokemon pokemon) {
        var imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/"
                + (pokemon.pokedexNumber) + ".png";
        var filePath = "images/" + pokemon.pokedexNumber + ".png";
        if (!Files.exists(Paths.get(filePath))) {
            try {
                Files.createDirectories(Paths.get("images"));
            } catch (Exception e) {
                System.out.println("Failed to create images directory");
                e.printStackTrace();
            }
            ImageDownloader.DownloadImage(imageUrl, filePath);
        }
        return filePath;
    }

    private String getPokemonLabel(Pokemon pokemon) {
        StringBuilder labelContent = new StringBuilder();
        labelContent.append("<<TABLE BORDER=\"1\" CELLBORDER=\"1\" CELLSPACING=\"0\">").append("\n");
        labelContent.append("<TR><TD><B>").append(pokemon.name).append("</B></TD></TR>").append("\n");
        labelContent.append("<TR><TD>HP: ").append(pokemon.hp).append("</TD></TR>").append("\n");
        labelContent.append("<TR><TD>Attack: ").append(pokemon.attack).append("</TD></TR>").append("\n");
        labelContent.append("<TR><TD>Moves:</TD></TR>").append("\n");
        for (Move move : pokemon.moves) {
            labelContent.append("<TR><TD>* ").append(move.name).append("</TD></TR>").append("\n");
        }
        labelContent.append("</TABLE>>");
        return labelContent.toString();
    }

    public void addState(State state) {

    }

    @Override
    public String toString() {
        content.append("}");
        return content.toString();
    }

    public void addLine(String line) {
        content.append(line).append("\n");
    }
}

class DotFileNode {
    public String name;
    public String label;
    public Map<String, String> attributes;

    public DotFileNode(String name, String label) {
        this.name = name;
        this.label = label;
        this.attributes = new HashMap<String, String>();
    }

    public void addAttribute(String name, String value) {
        attributes.put(name, value);
    }

    public void addAttributeWithQuotes(String name, String value) {
        addAttribute(name, "\"" + value + "\"");
    }

    @Override
    public String toString() {
        StringBuilder node = new StringBuilder();
        node.append(name).append(" [").append("\n");
        node.append("label=").append(label).append("\n");
        for (Map.Entry<String, String> entry : attributes.entrySet()) {
            node.append(", ").append(entry.getKey()).append("=").append(entry.getValue()).append("\n");
        }
        node.append("];").append("\n");
        return node.toString();
    }
}
