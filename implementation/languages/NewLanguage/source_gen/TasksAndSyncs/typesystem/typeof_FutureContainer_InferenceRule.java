package TasksAndSyncs.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.AbstractInferenceRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.InferenceRule_Runtime;
import org.jetbrains.mps.openapi.model.SNode;
import jetbrains.mps.typesystem.inference.TypeCheckingContext;
import jetbrains.mps.lang.typesystem.runtime.IsApplicableStatus;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.typesystem.inference.EquationInfo;
import jetbrains.mps.smodel.SModelUtil_new;

public class typeof_FutureContainer_InferenceRule extends AbstractInferenceRule_Runtime implements InferenceRule_Runtime {
  public typeof_FutureContainer_InferenceRule() {
  }

  public void applyRule(final SNode futureContainer, final TypeCheckingContext typeCheckingContext, IsApplicableStatus status) {
    {
      final SNode taskType = typeCheckingContext.typeOf(SLinkOperations.getTarget(futureContainer, "task", true), "r:daf934de-3466-4fa8-a227-270fedb7e2f2(TasksAndSyncs.typesystem)", "6843270485077601981", true);
      typeCheckingContext.whenConcrete(taskType, new Runnable() {
        public void run() {
          SNode futureType = SConceptOperations.createNewNode("TasksAndSyncs.structure.FutureType", null);
          SLinkOperations.setTarget(futureType, "returnType", SNodeOperations.copyNode(SLinkOperations.getTarget(SNodeOperations.as(typeCheckingContext.getExpandedNode(taskType), "TasksAndSyncs.structure.TaskType"), "returnType", true)), true);

          {
            SNode _nodeToCheck_1029348928467 = futureContainer;
            EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:daf934de-3466-4fa8-a227-270fedb7e2f2(TasksAndSyncs.typesystem)", "6843270485077601973", 0, null);
            typeCheckingContext.createEquation((SNode) typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:daf934de-3466-4fa8-a227-270fedb7e2f2(TasksAndSyncs.typesystem)", "6843270485077601977", true), (SNode) futureType, _info_12389875345);
          }
        }
      }, "r:daf934de-3466-4fa8-a227-270fedb7e2f2(TasksAndSyncs.typesystem)", "6843270485077601953", false, false);
    }
  }

  public String getApplicableConceptFQName() {
    return "TasksAndSyncs.structure.FutureContainer";
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
