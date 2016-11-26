enum Orientation {
    N,
    E,
    S,
    W;

    Orientation left() {
        switch (this) {
            case N: return Orientation.W;
            case E: return Orientation.N;
            case S: return Orientation.E;
            case W: return Orientation.S;
            default: return this;
        }
    }

    Orientation right() {
        switch (this) {
            case N: return Orientation.E;
            case E: return Orientation.S;
            case S: return Orientation.W;
            case W: return Orientation.N;
            default: return this;
        }
    }
}