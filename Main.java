// Pacotes importados
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

class Main {
  // Metodo para calcular idade
  public static int calculaIdade(java.util.Date dataNasc) {

    Calendar dataNascimento = Calendar.getInstance();  
    dataNascimento.setTime(dataNasc); 
    Calendar hoje = Calendar.getInstance();  

    int idade = hoje.get(Calendar.YEAR) - 
    dataNascimento.get(Calendar.YEAR); 

    if (hoje.get(Calendar.MONTH) < 
    dataNascimento.get(Calendar.MONTH)) {
      idade--;  
    } 
    else 
    { 
        if (hoje.get(Calendar.MONTH) == 
        dataNascimento.get(Calendar.MONTH) && 
        hoje.get(Calendar.DAY_OF_MONTH) < 
        dataNascimento.get(Calendar.DAY_OF_MONTH)) {
            idade--; 
        }
    }
    return idade;
}

  public static void main(String[] args) throws ParseException {
    // Classe Scanner instanciada 
    Scanner entrada = new Scanner(System.in);
    // Entradas
    // Nome do paciente
    System.out.println("Digite o nome do paciente: ");
    String nome = entrada.nextLine();
    // Sexo M ou F
    System.out.println("Digite o sexo M ou F: ");
    String sexo = entrada.nextLine();
    // Data de nascimento
    System.out.println("Digite a data do nascimento: (dd/mm/aaaa)");
    String nascimento = entrada.nextLine();
    // Altura
    System.out.println("Digite a altura: ");
    double altura = entrada.nextDouble();
    // Peso
    System.out.println("Digite o seu peso");
    int peso = entrada.nextInt();
    
    // Saidas
    System.out.println("RELATÓRIO MÉDICO" + "\n");
    System.out.println("Nome: " + nome);
    System.out.println("Sexo: " + sexo); 
    // Mudando formato da data
    DateTimeFormatter fmt = 
    DateTimeFormatter.ofPattern("dd/MM/yyyy");
    LocalDate data = LocalDate.parse(nascimento, fmt);
    System.out.printf("Nascimento: %s\n", data);
    // Chamando o metodo para calcular a idade de acordo com a data de nascimento
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    Date dataNascimento = sdf.parse(nascimento); 
    int idade = calculaIdade(dataNascimento);
    System.out.println("Idade: " +  idade + " " + "anos");
    System.out.printf("Altura: %.2f m\n", altura);
    System.out.println("Peso: " + peso + " " + "kgs");
    
    // Calculo do IMC
    double imc = peso / (altura * altura);
    
    // Condições
    if(imc < 17) {
      System.out.printf("IMC: %.2f - Muito Abaixo do Peso\n", imc);
    } 
    else if (imc > 17 && imc < 18.49) {
      System.out.printf("IMC: %.2f - Abaixo do Peso\n", imc);
    } 
    else if(imc > 18.49 && imc < 24.99) {
      System.out.printf("IMC: %.2f - Peso Normal\n", imc);
    }
    else if(imc > 24.99 && imc < 29.99) {
      System.out.printf("IMC: %.2f - Acima do Peso\n", imc);
    }
    else if(imc > 29.99 && imc < 34.99) {
      System.out.printf("IMC: %.2f - Obsidade I\n", imc);
    }
    else if(imc > 34.99 && imc < 39.99) {
      System.out.printf("IMC: %.2f - Obsidade II (Severa)\n", imc);
    }
    else if(imc > 40) {
      System.out.printf("IMC: %.2f - Obsidade III (Mórbida)\n", imc);
    }
    System.out.printf("Peso Ideal: %.2f kgs\n", (peso * altura) - 58);

  }
}