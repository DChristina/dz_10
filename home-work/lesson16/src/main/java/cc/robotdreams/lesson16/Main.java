package lesson16.src.main.java.cc.robotdreams.lesson16;

import lesson16.src.main.java.cc.robotdreams.lesson16.exceptions.WrongAccountException;
import lesson16.src.main.java.cc.robotdreams.lesson16.exceptions.WrongCurrencyException;
import lesson16.src.main.java.cc.robotdreams.lesson16.exceptions.WrongOperationException;

import java.sql.SQLOutput;

public class Main
{
    static BankApplication bankApp = new BankApplication();

    public static void main(String[] args) throws Exception {

            processWrapper("accountId000",50,"USD");
            processWrapper("accountId003",250,"HRV");
            processWrapper("accountId001",50,"EUR");
            processWrapper("accountId001",50,"USD");
            processWrapper("accountId001",100,"USD");
    }

    public static void processWrapper(String accId, int amount, String curr) throws Exception {
        try{
             bankApp.process(accId,amount,curr);
        } catch (WrongAccountException e){
            System.out.println("Такого акаунту не існує" );
        } catch (WrongCurrencyException e){
            System.out.println("Акаунт має рахунок в іншій валюті" );
        } catch(WrongOperationException e) {
            System.out.println("Акаунт не має достатньо коштів" );
        } catch(Exception e){
            System.out.println("Сталася помилка при процесінгу, спробуйте ще раз" );
        } finally {

            System.out.println(accId + " " + amount + " " + curr + " " + ":");
            System.out.println("Дякуємо, що скористалися нашим сервісом" );
            System.out.println("-----------------------------------------" );
        }
    }


}
