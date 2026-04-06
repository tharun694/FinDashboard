package com.FinDashboard.service;

import com.FinDashboard.entity.Transaction;
import com.FinDashboard.entity.User;
import com.FinDashboard.enums.Role;
import com.FinDashboard.enums.Type;
import com.FinDashboard.repository.Transactionrepo;
import com.FinDashboard.repository.UserRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class TransactionService {
    Transactionrepo repo;
    UserRepo userRepo;
    User user;
TransactionService(Transactionrepo repo,UserRepo userRepo){
    this.repo=repo;
    this.userRepo=userRepo;
}
    public Transaction addTransaction(Transaction transaction,Long adminId) {
 user=userRepo.findById(adminId).orElseThrow(()->new RuntimeException("user not found"));
        if(user.getRole()!=Role.ADMIN) throw new RuntimeException("Acess Denied");
        return repo.save(transaction);
    }

    public List<Transaction> getTransactions(Long user_id) {
        User user = userRepo.findById(user_id).orElseThrow(()->
                new RuntimeException("User not Found "));
    if(user.getRole()==Role.VIEWER){
        throw new RuntimeException("Acess Denied");
    }
        return  repo.findAll();
    }

    public Map<String, Double> getSummary(Long adminId,Long userId) {
        User user = userRepo.findById(adminId).orElseThrow(()->
                new RuntimeException("User not Found "));
        double income = 0.0;
        double expense = 0.0;
        if(user.getRole()!=Role.ADMIN&&user.getRole()!=Role.ANALYST) {
            throw new RuntimeException();
        }
            List<Transaction> list = repo.findByuserId(userId);
            System.out.println(list);
            for (Transaction t : list) {
                if (t.getType() == Type.EXPENSE) {
                    expense += t.getAmount();
                } else {
                    income += t.getAmount();
                }
            }

        //summary of transaction by user_id
        double balance = income - expense;
        return    Map.of("Income: ", income,
                "Expense: ", expense,
                "Balance: ", balance);
    }

    public void deleteTransaction(Long userId,Long transId) {
        User user = userRepo.findById(userId).orElseThrow(()->
                new RuntimeException("User not Found "));
        if(user.getRole()!=Role.ADMIN) throw new RuntimeException("Acess Denied");
    repo.deleteById(transId);
    }
    public Map<String, Map<String, Double>> getMonthlySummary(Long adminId,Long userId) {
        User user = userRepo.findById(userId).orElseThrow(()->
                new RuntimeException("User not Found "));
        if(user.getRole()!=Role.ADMIN&&user.getRole()!=Role.ANALYST) {
            throw new RuntimeException();
        }

        List<Transaction> list = repo.findByuserId(userId);

        Map<String, Map<String, Double>> result = new HashMap<>();

        for (Transaction t : list) {

            String month = t.getDate().getMonth().toString(); // MONTH

            result.putIfAbsent(month, new HashMap<>());
            Map<String, Double> data = result.get(month);

            data.putIfAbsent("income", 0.0);
            data.putIfAbsent("expense", 0.0);

            if (t.getType() == Type.INCOME) {
                data.put("income", data.get("income") + t.getAmount());
            } else {
                data.put("expense", data.get("expense") + t.getAmount());
            }

            double balance = data.get("income") - data.get("expense");
            data.put("balance", balance);
        }

        return result;
    }

    public Map<String, Double> getCategoryAnalysis(Long adminId,Long userId) {

        User user = userRepo.findById(userId).orElseThrow(()->
                new RuntimeException("User not Found "));
        if(user.getRole()!=Role.ADMIN&&user.getRole()!=Role.ANALYST) {
            throw new RuntimeException();
        }
        List<Transaction> list = repo.findByuserId(userId);

        Map<String, Double> result = new HashMap<>();

        for (Transaction t : list) {

            if (t.getType() == Type.EXPENSE) {

                result.put(
                        t.getCategory(),
                        result.getOrDefault(t.getCategory(), 0.0) + t.getAmount()
                );
            }
        }

        return result;
    }

    public List<Transaction> gettransactionsByid(Long userId) {
    User user=userRepo.findById(userId).orElseThrow(()->new RuntimeException("user not found"));
//    if(user.getRole()==Role.ANALYST||user.getRole()==Role.VIEWER){
//
//    }
        return repo.findByuserId(userId);

    }
}
