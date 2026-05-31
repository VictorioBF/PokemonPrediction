/*
Cria Pokemon e golpes utilizados na simulacao.
Hoje existem apenas dois Pokemon e poucos golpes.
O trabalho pede dois times completos com seis Pokemon cada.
*/
import java.util.List;

public class FabricaDeDados {

    public static Golpe Flamethrower =
            new Golpe(
                    "Flamethrower",
                    Tipo.FIRE,
                    CategoriaGolpe.SPECIAL,
                    90
            );

    public static Golpe Recover =
            new Golpe(
                    "Recover",
                    Tipo.NORMAL,
                    CategoriaGolpe.STATUS,
                    0
            );

    public static Golpe HydroPump =
            new Golpe(
                    "Hydro Pump",
                    Tipo.WATER,
                    CategoriaGolpe.SPECIAL,
                    110
            );

    public static Pokemon charizard() {

        return new Pokemon(
                "Charizard",
                List.of(Tipo.FIRE, Tipo.FLYING),
                78,
                84,
                78,
                109,
                85,
                100,
                List.of(
                        Flamethrower,
                        Recover
                )
        );
    }

    public static Pokemon blastoise() {

        return new Pokemon(
                "Blastoise",
                List.of(Tipo.WATER),
                79,
                83,
                100,
                85,
                105,
                78,
                List.of(
                        HydroPump,
                        Recover
                )
        );
    }
}