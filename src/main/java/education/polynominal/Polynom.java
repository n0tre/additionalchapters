package education.polynominal;

import java.util.*;

public class Polynom {
    private final List<Integer> cfs;
    private final Map<String, Integer> polynom;
    private final int polynomDegree;

    public Polynom(int polynomialDegree, List<Integer> coefficients){
        this.polynomDegree = polynomialDegree;
        this.cfs = coefficients;
        polynom = new HashMap<>();
        for (int i = coefficients.size() - 1, j = 0; i >= 0 && j <= coefficients.size(); i--, j++) {
            polynom.put("x^" + i, coefficients.get(j));
        }
    }

    private int calculate(Integer Value) {
        int result = 0;
        for (int i = 0, j = cfs.size() - 1; i < cfs.size() && j >= 0; i++, j--) {
            result += cfs.get(j) * Math.pow(Value, i);
        }
        return result;
    }

    public boolean isBiective() {
        Map<Integer, Integer> residue = new HashMap<>();
        for (int i = 0; i < 4; i++) {
            residue.put(i, calculate(i) % 4);
        }
        Set<Integer> residues = new HashSet<>(residue.values());
        return residues.size() == 4;
    }

    public boolean isTransitive() {
        boolean isTransitive = false;
        List<Integer> residue = new ArrayList<>();
        residue.add(0);
        int i = 0;
        while (!isTransitive) {
            int newVal = calculate(residue.get(i)) % 8;
            residue.add(newVal);
            Set<Integer> residues = new HashSet<>(residue);
            if (newVal == residue.get(0) && residues.size() == 8) {
                isTransitive = true;
            }
            i++;
            if (!isTransitive && i > 8) {
                break;
            }
        }
        return isTransitive;
    }
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Map.Entry<String, Integer> item : polynom.entrySet()) {
            if (item.getValue() != 1) {
                str.append(item.getValue());
            }
            if (item.getValue() != 0) {
                str.append(item.getKey());
            } else {
                str.append(item.getValue());
            }
            str.append(" + ");
        }
        str.deleteCharAt(str.lastIndexOf("+"));
        return str.toString();
    }
}
