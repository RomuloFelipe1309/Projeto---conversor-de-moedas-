import java.util.Scanner;

public class ConversorMoedas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Conversor conversor = new Conversor();
        boolean continuar = true;

        while (continuar) {
            conversor.menuConversor(scanner);

            if (conversor.getMoedaBaseNumero() == 0 || conversor.getMoedaConvertidaNumero() == 0) {
                System.out.println("Encerrando o programa.");
                System.out.printf("Obrigado por usar o conversor de moedas!");
                continuar = false;
                continue;
            }

            double taxa = conversor.buscarTaxaConversao();
            double convertido = conversor.getValorParaConverter() * taxa;

            System.out.printf("💱 %.2f %s = %.2f %s%n",
                    conversor.getValorParaConverter(),
                    conversor.getMoedaBase(),
                    convertido,
                    conversor.getMoedaConvertida()
            );
        }
        scanner.close();
    }
}
