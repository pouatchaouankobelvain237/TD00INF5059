package Knapsack_Java;
import java.util.ArrayList;
import java.util.List;

public class knapsack {
	// Résolution du problème du sac à dos 0/1 avec programmation dynamique
    public static int knapsack(int[] values, int[] weights, int W) {
        int n = values.length;
        int[][] dp = new int[n + 1][W + 1];

        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(values[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }
        
        return dp[n][W];
    }
    
    // Récupération des éléments inclus dans la solution optimale
    public static List<Integer> getSelectedItems(int[] values, int[] weights, int W) {
        int n = values.length;
        int[][] dp = new int[n + 1][W + 1];
        
        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(values[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }
        
        List<Integer> selectedItems = new ArrayList<>();
        int w = W;
        for (int i = n; i > 0 && w > 0; i--) {
            if (dp[i][w] != dp[i - 1][w]) {
                selectedItems.add(i - 1);
                w -= weights[i - 1];
            }
        }
        return selectedItems;
    }
    
    public static void main(String[] args) {
        int[] values = {60, 100, 120};
        int[] weights = {10, 20, 30};
        int W = 50;
        
        int maxValue = knapsack(values, weights, W);
        List<Integer> selectedItems = getSelectedItems(values, weights, W);
        
        System.out.println("Valeur maximale obtenue : " + maxValue);
        System.out.println("Objets sélectionnés : " + selectedItems);
    }

}
