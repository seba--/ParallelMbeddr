package TasksAndSyncs.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.AbstractInferenceRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.InferenceRule_Runtime;
import org.jetbrains.mps.openapi.model.SNode;
import jetbrains.mps.typesystem.inference.TypeCheckingContext;
import jetbrains.mps.lang.typesystem.runtime.IsApplicableStatus;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.errors.messageTargets.MessageTarget;
import jetbrains.mps.errors.messageTargets.NodeMessageTarget;
import jetbrains.mps.errors.IErrorReporter;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.typesystem.inference.EquationInfo;
import jetbrains.mps.smodel.SModelUtil_new;

public class typeof_JoinedTask_InferenceRule extends AbstractInferenceRule_Runtime implements InferenceRule_Runtime {
  public typeof_JoinedTask_InferenceRule() {
  }

  public void applyRule(final SNode joinedTask, final TypeCheckingContext typeCheckingContext, IsApplicableStatus status) {
    {
      final SNode taskAsExprType = typeCheckingContext.typeOf(SLinkOperations.getTarget(joinedTask, "runningTask", true), "r:daf934de-3466-4fa8-a227-270fedb7e2f2(TasksAndSyncs.typesystem)", "1304213873212854739", true);
      typeCheckingContext.whenConcrete(taskAsExprType, new Runnable() {
        public void run() {
          if (!(SNodeOperations.isInstanceOf(typeCheckingContext.getExpandedNode(taskAsExprType), "TasksAndSyncs.structure.RunningTaskType"))) {
            {
              MessageTarget errorTarget = new NodeMessageTarget();
              IErrorReporter _reporter_2309309498 = typeCheckingContext.reportTypeError(SLinkOperations.getTarget(joinedTask, "runningTask", true), "expression to run is not a running task ", "r:daf934de-3466-4fa8-a227-270fedb7e2f2(TasksAndSyncs.typesystem)", "1304213873214551014", null, errorTarget);
            }
          }

          SNode runningtaskType = SNodeOperations.as(typeCheckingContext.getExpandedNode(taskAsExprType), "TasksAndSyncs.structure.RunningTaskType");
          SNode joinedTaskType = SConceptOperations.createNewNode("TasksAndSyncs.structure.JoinedTaskType", null);

          for (SNode argumentType : ListSequence.fromList(SLinkOperations.getTargets(runningtaskType, "argumentTypes", true))) {
            ListSequence.fromList(SLinkOperations.getTargets(joinedTaskType, "argumentTypes", true)).addElement(SNodeOperations.copyNode(argumentType));
          }
          SLinkOperations.setTarget(joinedTaskType, "returnType", SNodeOperations.copyNode(SLinkOperations.getTarget(runningtaskType, "returnType", true)), true);

          {
            SNode _nodeToCheck_1029348928467 = joinedTask;
            EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:daf934de-3466-4fa8-a227-270fedb7e2f2(TasksAndSyncs.typesystem)", "1304213873212854728", 0, null);
            typeCheckingContext.createEquation((SNode) typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:daf934de-3466-4fa8-a227-270fedb7e2f2(TasksAndSyncs.typesystem)", "1304213873212854734", true), (SNode) joinedTaskType, _info_12389875345);
          }

        }
      }, "r:daf934de-3466-4fa8-a227-270fedb7e2f2(TasksAndSyncs.typesystem)", "1304213873212854692", false, false);
    }
  }

  public String getApplicableConceptFQName() {
    return "TasksAndSyncs.structure.JoinedTask";
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