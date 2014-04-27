package visitors;

import model.*;

public class PrettyPrinter implements ExpVisitor {

    public void visit(Num exp) {
        System.out.print(exp.number);
    }

    public void visit(Div exp) {
        Div div = exp;
        div.left.accept(this);
        System.out.print(" / ");
        div.right.accept(this);
    }

    public void visit(Mul exp) {
        Mul mul = exp;
        mul.left.accept(this);
        System.out.print(" * ");
        mul.right.accept(this);
    }

    public void visit(Sum exp) {
        Sum sum = exp;
        System.out.print("(");
        sum.left.accept(this);
        System.out.print(" + ");
        sum.right.accept(this);
        System.out.print(")");
    }

    public void visit(Var exp) {
        System.out.print(exp.name);
    }

    public void visit(Assign assign) {
        System.out.print(assign.name);
        System.out.print(" = ");
        assign.expr.accept(this);
    }
}
