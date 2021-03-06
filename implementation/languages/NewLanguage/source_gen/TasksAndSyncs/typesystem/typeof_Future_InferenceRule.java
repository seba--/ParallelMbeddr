package TasksAndSyncs.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.AbstractInferenceRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.InferenceRule_Runtime;
import org.jetbrains.mps.openapi.model.SNode;
import jetbrains.mps.typesystem.inference.TypeCheckingContext;
import jetbrains.mps.lang.typesystem.runtime.IsApplicableStatus;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.typesystem.inference.EquationInfo;
import jetbrains.mps.smodel.SModelUtil_new;

public class typeof_Future_InferenceRule extends AbstractInferenceRule_Runtime implements InferenceRule_Runtime {
  public typeof_Future_InferenceRule() {
  }

  public void applyRule(final SNode future, final TypeCheckingContext typeCheckingContext, IsApplicableStatus status) {
    final SNode task = SLinkOperations.getTarget(SNodeOperations.as(SNodeOperations.getParent(future), "com.mbeddr.core.expressions.structure.GenericDotExpression"), "expression", true);
    {
      final SNode taskAsExprType = typeCheckingContext.typeOf(task, "r:daf934de-3466-4fa8-a227-270fedb7e2f2(TasksAndSyncs.typesystem)", "1304213873210950506", true);
      typeCheckingContext.whenConcrete(taskAsExprType, new Runnable() {
        public void run() {
          SNode futureType = SConceptOperations.createNewNode("TasksAndSyncs.structure.FutureType", null);
          SLinkOperations.setTarget(futureType, "returnType", SNodeOperations.copyNode(SLinkOperations.getTarget(SNodeOperations.as(typeCheckingContext.getExpandedNode(taskAsExprType), "TasksAndSyncs.structure.TaskType"), "returnType", true)), true);

          {
            SNode _nodeToCheck_1029348928467 = future;
            EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:daf934de-3466-4fa8-a227-270fedb7e2f2(TasksAndSyncs.typesystem)", "1304213873206867523", 0, null);
            typeCheckingContext.createEquation((SNode) typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:daf934de-3466-4fa8-a227-270fedb7e2f2(TasksAndSyncs.typesystem)", "1304213873206867527", true), (SNode) futureType, _info_12389875345);
          }
        }
      }, "r:daf934de-3466-4fa8-a227-270fedb7e2f2(TasksAndSyncs.typesystem)", "1304213873210942623", false, false);
    }
  }

  public String getApplicableConceptFQName() {
    return "TasksAndSyncs.structure.Future";
  }

  public IsApplicableStatus isApplicableAndPattern(SNode argument) {
    {
      boolean b = SModelUtil_new.isAssignableConcept(argument.getConcept().getQualifiedName(), this.getApplicableConceptFQName());
      return new IsApplicableStatus(b, null);
    }
  }

  public boolean overrides() {
    return false;
  }
}
