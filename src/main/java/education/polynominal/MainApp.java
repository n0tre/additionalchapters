package education.polynominal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public final class MainApp {
    public static void main(String[] args) {
        MainApp test = new MainApp();
        test.start();
    }

        public void start() {
            Polynom polynom = createPolynom();
            transitiveTest(polynom);
            biectiveTest(polynom);
       }

        public List<Integer> enterCfs ( int polynomialDegree){
            Scanner in = new Scanner(System.in);
            List<Integer> cfs = new ArrayList<>();
            for (int i = polynomialDegree; i >= 0; i--) {
                System.out.println("Введите коэффициент для х в " + i + " степени :");
                cfs.add(in.nextInt());
            }
            return cfs;
        }

        public Polynom createPolynom () {
            Scanner in = new Scanner(System.in);
            System.out.print("Введите степень полинома: ");
            int polynomDegree = in.nextInt();
            List<Integer> coefficients = enterCfs(polynomDegree);
            return new Polynom(polynomDegree, coefficients);
        }

        public void biectiveTest (Polynom polynom){
            if (polynom.isBiective()) {
                System.out.println("Полином F= " + polynom.toString() + " биективеный");
            } else {
                System.out.println("Полином F= " + polynom.toString() + " не биективный");
            }
        }

        public void transitiveTest (Polynom polynom){
            if (polynom.isTransitive()) {
                System.out.println("Полином F= " + polynom.toString() + " транзитивный");
            } else {
                System.out.println("Полином F= " + polynom.toString() + " не транзитивный");
            }
        }
    }

