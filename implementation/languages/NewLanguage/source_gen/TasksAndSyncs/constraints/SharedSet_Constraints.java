package TasksAndSyncs.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.runtime.base.BaseConstraintsDescriptor;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.mps.openapi.model.SNode;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.runtime.CheckingNodeContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.typesystem.inference.TypeChecker;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.smodel.SNodePointer;

public class SharedSet_Constraints extends BaseConstraintsDescriptor {
  public SharedSet_Constraints() {
    super("TasksAndSyncs.structure.SharedSet");
  }

  @Override
  public boolean hasOwnCanBeChildMethod() {
    return true;
  }

  @Override
  public boolean canBeChild(@Nullable SNode node, SNode parentNode, SNode link, SNode childConcept, final IOperationContext operationContext, @Nullable final CheckingNodeContext checkingNodeContext) {
    boolean result = static_canBeAChild(node, parentNode, link, childConcept, operationContext);

    if (!(result) && checkingNodeContext != null) {
      checkingNodeContext.setBreakingNode(canBeChildBreakingPoint);
    }

    return result;
  }

  public static boolean static_canBeAChild(SNode node, SNode parentNode, SNode link, SNode childConcept, final IOperationContext operationContext) {
    if (!(SNodeOperations.isInstanceOf(parentNode, "com.mbeddr.core.expressions.structure.GenericDotExpression"))) {
      return false;
    }
    SNode expressionType = TypeChecker.getInstance().getTypeOf(SLinkOperations.getTarget(SNodeOperations.cast(parentNode, "com.mbeddr.core.expressions.structure.GenericDotExpression"), "expression", true));
    if (!(SNodeOperations.isInstanceOf(expressionType, "TasksAndSyncs.structure.SharedType")) && !(SNodeOperations.isInstanceOf(expressionType, "com.mbeddr.core.pointers.structure.PointerType") && SNodeOperations.isInstanceOf(SLinkOperations.getTarget(SNodeOperations.cast(expressionType, "com.mbeddr.core.pointers.structure.PointerType"), "baseType", true), "TasksAndSyncs.structure.SharedType"))) {
      return false;
    }
    return !(SNodeOperations.isInstanceOf(SLinkOperations.getTarget(SNodeOperations.cast(expressionType, "TasksAndSyncs.structure.SharedType"), "baseType", true), "com.mbeddr.core.expressions.structure.VoidType"));
  }

  private static SNodePointer canBeChildBreakingPoint = new SNodePointer("r:1131838a-735d-45d7-9c86-9e6994478367(TasksAndSyncs.constraints)", "3570654511858680087");
}
