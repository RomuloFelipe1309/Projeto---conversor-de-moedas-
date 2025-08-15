import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Conversor {
    private int moedaBaseNumero;
    private int moedaConvertidaNumero;
    private String moedaBase;
    private String moedaConvertida;
    private double valorParaConverter;

    // Menu de opções
    public void menuConversor(Scanner scanner) {
        System.out.println("""
                *********************************************************
                Olá! Seja muito bem-vindo ao conversor de moedas!

                Digite o número correspondente à moeda base:
                (1) USD - Dólar americano
                (2) BRL - Real brasileiro
                (3) EUR - Euro
                (4) ARS - Peso argentino
                (5) CLP - Peso chileno
                (6) BOB - Peso boliviano
                (7) COP - Peso colombiano
                (8) GBP - Libra Esterlina
                (9) JPY - Iene japonês
                (0) Sair
                *********************************************************
                """);
        moedaBaseNumero = scanner.nextInt();

        if (moedaBaseNumero == 0) return;

        System.out.println("""
                *********************************************************
                Escolha a moeda de destino:
                (1) USD - Dólar americano
                (2) BRL - Real brasileiro
                (3) EUR - Euro
                (4) ARS - Peso argentino
                (5) CLP - Peso chileno
                (6) BOB - Peso boliviano
                (7) COP - Peso colombiano
                (8) GBP - Libra Esterlina
                (9) JPY - Iene japonês
                (0) Sair
                *********************************************************
                """);
        moedaConvertidaNumero = scanner.nextInt();

        if (moedaConvertidaNumero == 0) return;

        System.out.print("Digite o valor que deseja converter: ");
        valorParaConverter = scanner.nextDouble();

        moedaBase = getCodigoPorNumero(moedaBaseNumero);
        moedaConvertida = getCodigoPorNumero(moedaConvertidaNumero);
    }

    private String getCodigoPorNumero(int numero) {
        return switch (numero) {
            case 1 -> "USD";
            case 2 -> "BRL";
            case 3 -> "EUR";
            case 4 -> "ARS";
            case 5 -> "CLP";
            case 6 -> "BOB";
            case 7 -> "COP";
            case 8 -> "GBP";
            case 9 -> "JPY";
            default -> null;
        };
    }

    public double buscarTaxaConversao() {
        try {
            String urlStr = "https://v6.exchangerate-api.com/v6/2ac2612163da5f696fe4495f/latest/" + moedaBase;
            URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            // Lendo a resposta
            Scanner sc = new Scanner(url.openStream());
            StringBuilder resposta = new StringBuilder();
            while (sc.hasNext()) {
                resposta.append(sc.nextLine());
            }
            sc.close();

            JsonObject json = JsonParser.parseString(resposta.toString()).getAsJsonObject();
            JsonObject rates = json.getAsJsonObject("conversion_rates");

            JsonElement element = rates.get(moedaConvertida); // ex: "BRL"
            if (element == null || element.isJsonNull()) {
                throw new IllegalArgumentException("Moeda não encontrada: " + moedaConvertida);
            }
            double taxa = element.getAsDouble();
            return taxa;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public double getValorParaConverter() {
        return valorParaConverter;
    }

    public String getMoedaBase() {
        return moedaBase;
    }

    public String getMoedaConvertida() {
        return moedaConvertida;
    }

    public int getMoedaBaseNumero() {
        return moedaBaseNumero;
    }

    public int getMoedaConvertidaNumero() {
        return moedaConvertidaNumero;
    }
}
