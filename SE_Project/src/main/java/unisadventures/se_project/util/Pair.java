package unisadventures.se_project.util;

// Code taken from https://stackoverflow.com/questions/457629/how-to-return-multiple-objects-from-a-java-method
// and adapted

public class Pair<A,B> {

    public static <P, Q> Pair<P, Q> makePair(P p, Q q) {
        return new Pair<P, Q>(p, q);
    }

    public final A _a;
    public final B _b;

    public Pair(A a, B b) {
        _a = a;
        _b = b;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((_a == null) ? 0 : _a.hashCode());
        result = prime * result + ((_b == null) ? 0 : _b.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        @SuppressWarnings("rawtypes")
        Pair other = (Pair) obj;
        if (_a == null) {
            if (other._a != null) {
                return false;
            }
        } else if (!_a.equals(other._a)) {
            return false;
        }
        if (_b == null) {
            if (other._b != null) {
                return false;
            }
        } else if (!_b.equals(other._b)) {
            return false;
        }
        return true;
    }

    public boolean isInstance(Class<?> classA, Class<?> classB) {
        return classA.isInstance(_a) && classB.isInstance(_b);
    }

    @SuppressWarnings("unchecked")
    public static <P, Q> Pair<P, Q> cast(Pair<?, ?> pair, Class<P> pClass, Class<Q> qClass) {

        if (pair.isInstance(pClass, qClass)) {
            return (Pair<P, Q>) pair;
        }

        throw new ClassCastException();

    }

}
