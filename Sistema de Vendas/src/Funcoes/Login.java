package Funcoes;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Login {

    public static int realizaLogin(String username, char[] password) {

        String passwordString = verificaPassword(password);
        Connection conn = Banco.conexao();

//Cria um query do BD onde será capturado do banco as informações do usuario 
        String query = "SELECT * FROM users WHERE username = \"" + username + "\" and password = \"" + passwordString + "\"";

        try {
//Verifica se existem campos em branco {
            if (username.equals("")) {
                JOptionPane.showMessageDialog(null,
                        "Nome de Usuario está vazio!", "Erro de validação", JOptionPane.ERROR_MESSAGE);
                return 0;
            }
            if (passwordString.equals("d41d8cd98f00b204e9800998ecf8427e")) {
                JOptionPane.showMessageDialog(null,
                        "Senha está vazia!", "Erro de valida��o", JOptionPane.ERROR_MESSAGE);
                return 0;
            }
//}fim da verificação de campos em branco

//Inicia uma conexão com o banco após as verificações {
            PreparedStatement stmt = conn.prepareStatement(query);

            stmt = conn.prepareStatement(query);

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                String usernamebd = rs.getString("username");
                String passwordbd = rs.getString("password");

		//System.out.println(usernamebd + " " + passwordbd);
                //System.out.println(username + " " + passwordString);
//Aqui, verifica se o nome de usuario realmente coincidem com o Banco de Dados{
                if (username.equals(usernamebd) && passwordString.equals(passwordbd)) {                    
                    
                    rs.close();
                    conn.close();
                    return 1;

                }
            }
//}Fim da verificação }

            rs.close();
            conn.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return 0;

    }

    private static String verificaPassword(char[] password) {

        StringBuilder s = new StringBuilder();
        String pwd = "";
        int pwdlenght = password.length;
        int counter = 0;

        while (counter < pwdlenght) {

            pwd = pwd + password[counter];

            counter++;

        }

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(pwd.getBytes());
            byte[] hashMd5 = md.digest();

            for (int i = 0; i < hashMd5.length; i++) {
                int parteAlta = ((hashMd5[i] >> 4) & 0xf) << 4;
                int parteBaixa = hashMd5[i] & 0xf;
                if (parteAlta == 0) {
                    s.append('0');
                }
                s.append(Integer.toHexString(parteAlta | parteBaixa));
            }

            System.out.println(s.toString());

        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return s.toString();
    }
}