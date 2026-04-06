package com.FinDashboard.controller;

import com.FinDashboard.entity.Transaction;
import com.FinDashboard.entity.User;
import com.FinDashboard.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController

public class TransactionController {

    private final TransactionService transervice;

    public TransactionController(TransactionService transervice) {
        this.transervice = transervice;
    }

    @RestControllerAdvice
    static class GlobalExceptionHandler {

        @ExceptionHandler(RuntimeException.class)
        public ResponseEntity<?> handle(RuntimeException ex) {
            return ResponseEntity.status(403).body(
                    Map.of(
                            "status", 403,
                            "error", "Forbidden",
                            "message", ex.getMessage()
                    )
            );
        }

        @ExceptionHandler(Exception.class)
        public ResponseEntity<?> handleAll(Exception ex) {
            return ResponseEntity.status(500).body(
                    Map.of(
                            "status", 500,
                            "error", "Internal Server Error",
                            "message", ex.getMessage()
                    )
            );
        }
    }

    @GetMapping("/greet")
    public ResponseEntity<?> greet() {
        return ResponseEntity.ok(
                Map.of("message", "App is working fine")
        );
    }

    @PutMapping("/transaction/{adminId}")
    public ResponseEntity<?> add(@RequestBody Transaction transaction,@PathVariable Long adminId) {
        Transaction saved = transervice.addTransaction(transaction,adminId);

        return ResponseEntity.status(201).body(
                Map.of(
                        "message", "Transaction added",
                        "data", saved
                )
        );
    }

    @GetMapping("/transactions/{user_id}")
    public ResponseEntity<?> gettransactions(@PathVariable Long user_id) {
        List<Transaction> transactions = transervice.getTransactions(user_id);

        return ResponseEntity.ok(
                Map.of(
                        "message", "Transactions fetched",
                        "data", transactions
                )
        );
    }

    @GetMapping("/summary/{adminId}/{userId}")
    public ResponseEntity<?> getSummary(@PathVariable Long adminId,
                                        @PathVariable Long userId) {
        Map<String, Double> data = transervice.getSummary(adminId,userId);

        return ResponseEntity.ok(
                Map.of(
                        "message", "Summary fetched",
                        "data", data
                )
        );
    }


    @GetMapping("/summary/monthly/{adminId}/{userId}")
    public ResponseEntity<?> getMonthly(@PathVariable Long adminId,@PathVariable Long userId) {
        Map<String, Map<String, Double>> data=transervice.getMonthlySummary(adminId,userId);
        return ResponseEntity.ok(Map.of("message","monthly summary","data",data));
    }

    @GetMapping("/analysis/category/{adminId}/{userId}")
    public ResponseEntity<?> getCategory(@PathVariable Long adminId,@PathVariable Long userId) {
        return ResponseEntity.ok(transervice.getCategoryAnalysis(adminId,userId));
    }
    @GetMapping("/{userId}")
    public ResponseEntity<List<Transaction>>gettransactionsById(@PathVariable Long userId){
        List<Transaction> list=transervice.gettransactionsByid(userId);
        return ResponseEntity.ok(list);
    }

    @DeleteMapping("{userId}/{transId}")
    public ResponseEntity<?> deletetransaction(
            @PathVariable Long userId,
            @PathVariable Long transId) {

        transervice.deleteTransaction(userId, transId);

        return ResponseEntity.ok(
                Map.of(
                        "message", "Transaction deleted successfully"
                )
        );
    }
}