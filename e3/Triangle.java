package e3;

import java.util.Objects;

public record Triangle(int angle0, int angle1, int angle2) {
    public Triangle {
        if (angle0 + angle1 + angle2 != 180) {
            throw new IllegalArgumentException("The angles do not sum 180 degrees");
        }
    }

    public Triangle(Triangle t) {
        this(t.angle0, t.angle1, t.angle2);
    }

    public boolean isRight() {
        return (angle0 == 90 || angle1 == 90 || angle2 == 90);
    }

    public boolean isAcute() {
        return (angle0 < 90 && angle1 < 90 && angle2 < 90);
    }

    public boolean isObtuse() {
        return (angle0 > 90 || angle1 > 90 || angle2 > 90);
    }

    public boolean isEquilateral() {
        return (angle0 == angle1 && angle1 == angle2);
    }

    public boolean isIsosceles() {
        return (((angle1 == angle2) && (angle2 != angle0)) || ((angle1 == angle0) && (angle0 != angle2)) || ((angle2 == angle0) && (angle2 != angle1)));
    }

    public boolean isScalene() {
        return (angle0 != angle1 && angle1 != angle2 && angle0 != angle2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (getClass() != o.getClass()) {
            return false;
        }
        Triangle t = (Triangle) o;
        if (this.angle0 == t.angle0) {
            if (this.angle1 == t.angle1 && this.angle2 == t.angle2) {
                return true;
            } else return this.angle1 == t.angle2 && this.angle2 == t.angle1;
        } else if (this.angle0 == t.angle1) {
            if (this.angle1 == t.angle0 && this.angle2 == t.angle2) {
                return true;
            } else return this.angle1 == t.angle2 && this.angle2 == t.angle0;
        } else if (this.angle0 == t.angle2) {
            if (this.angle1 == t.angle0 && this.angle2 == t.angle1) {
                return true;
            } else return this.angle1 == t.angle1 && this.angle2 == t.angle0;
        } else{
            return false;
        }
    }

    @Override
    public int hashCode(){
        return Objects.hash(angle0*angle1*angle2);
    }

}

