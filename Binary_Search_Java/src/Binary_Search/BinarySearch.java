package Binary_Search;

public class BinarySearch {
	// Méthode de recherche binaire
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            // Vérifier si l'élément du milieu est la cible
            if (arr[mid] == target) {
                return mid;
            }
            // Si la cible est plus grande, ignorer la moitié gauche
            else if (arr[mid] < target) {
                left = mid + 1;
            }
            // Si la cible est plus petite, ignorer la moitié droite
            else {
                right = mid - 1;
            }
        }
        
        // Si l'élément n'est pas trouvé
        return -1;

}

//Méthode principale pour tester la recherche binaire
public static void main(String[] args) {
    int[] sortedArray = {1, 3, 5, 7, 9, 11, 13, 15};
    int target = 15;
    
    int result = binarySearch(sortedArray, target);
    
    if (result != -1) {
        System.out.println("Element trouver a l'index : " + result);
    } else {
        System.out.println("Element non trouver dans le tableau.");
    }
}
}
