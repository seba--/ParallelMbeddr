package TasksAndSyncs.generator.util;

/*Generated by MPS */

import org.jetbrains.mps.openapi.model.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.smodel.behaviour.BehaviorReflection;

public class Analyzer {


  public static boolean isLValue(SNode expression) {
    if (SNodeOperations.isInstanceOf(expression, "com.mbeddr.core.statements.structure.LocalVarRef") || SNodeOperations.isInstanceOf(expression, "com.mbeddr.core.modules.structure.GlobalVarRef") || SNodeOperations.isInstanceOf(expression, "com.mbeddr.core.pointers.structure.DerefExpr")) {
      return true;
    }
    {
      SNode referenceExpression = expression;
      if (SNodeOperations.isInstanceOf(referenceExpression, "com.mbeddr.core.pointers.structure.ReferenceExpr")) {
        return isLValue(SLinkOperations.getTarget(referenceExpression, "expression", true));
      }
    }
    {
      SNode genericDotExpression = expression;
      if (SNodeOperations.isInstanceOf(genericDotExpression, "com.mbeddr.core.expressions.structure.GenericDotExpression")) {
        return isLValue(SLinkOperations.getTarget(genericDotExpression, "expression", true));
      }
    }
    {
      SNode arrayAccessExpression = expression;
      if (SNodeOperations.isInstanceOf(arrayAccessExpression, "com.mbeddr.core.pointers.structure.ArrayAccessExpr")) {
        return isLValue(SLinkOperations.getTarget(arrayAccessExpression, "expression", true));
      }
    }
    return false;
  }



  public static boolean taskExprContainsRebindableRefs(SNode taskExpression) {
    return (SNodeOperations.isInstanceOf(taskExpression, "com.mbeddr.core.statements.structure.IVariableReference") && !(SNodeOperations.isInstanceOf(taskExpression, "com.mbeddr.core.modules.structure.GlobalVarRef"))) || ListSequence.fromList(SNodeOperations.getDescendants(taskExpression, "com.mbeddr.core.statements.structure.IVariableReference", false, new String[]{})).where(new IWhereFilter<SNode>() {
      public boolean accept(SNode it) {
        return !(SNodeOperations.isInstanceOf(it, "com.mbeddr.core.modules.structure.GlobalVarRef"));
      }
    }).count() > 0;
  }



  public static SNode getSurroundingFunctionOrClosure(SNode node) {
    SNode closure = SNodeOperations.getAncestor(node, "com.mbeddr.core.modules.structure.Closure", false, false);
    if ((closure != null)) {
      return closure;
    }
    return SNodeOperations.getAncestor(node, "com.mbeddr.core.modules.structure.Function", false, false);
  }



  public static boolean stmtContainsSyncRessExpr(SNode stmt, final SNode syncRessExpr) {
    if (!(SNodeOperations.isInstanceOf(syncRessExpr, "com.mbeddr.core.statements.structure.IVariableReference"))) {
      return false;
    }
    return ListSequence.fromList(SNodeOperations.getDescendants(stmt, "com.mbeddr.core.statements.structure.IVariableReference", false, new String[]{})).any(new IWhereFilter<SNode>() {
      public boolean accept(SNode it) {
        return BehaviorReflection.invokeVirtual((Class<SNode>) ((Class) Object.class), it, "virtual_getVariable_2486081302460156153", new Object[]{}) == BehaviorReflection.invokeVirtual((Class<SNode>) ((Class) Object.class), SNodeOperations.cast(syncRessExpr, "com.mbeddr.core.statements.structure.IVariableReference"), "virtual_getVariable_2486081302460156153", new Object[]{});
      }
    });
  }
}
