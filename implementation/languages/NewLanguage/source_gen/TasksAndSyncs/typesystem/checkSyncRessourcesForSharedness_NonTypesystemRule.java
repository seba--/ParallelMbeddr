package TasksAndSyncs.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.AbstractNonTypesystemRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.NonTypesystemRule_Runtime;
import org.jetbrains.mps.openapi.model.SNode;
import jetbrains.mps.typesystem.inference.TypeCheckingContext;
import jetbrains.mps.lang.typesystem.runtime.IsApplicableStatus;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.typesystem.inference.TypeChecker;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.errors.messageTargets.MessageTarget;
import jetbrains.mps.errors.messageTargets.NodeMessageTarget;
import jetbrains.mps.errors.IErrorReporter;
import jetbrains.mps.smodel.SModelUtil_new;

public class checkSyncRessourcesForSharedness_NonTypesystemRule extends AbstractNonTypesystemRule_Runtime implements NonTypesystemRule_Runtime {
  public checkSyncRessourcesForSharedness_NonTypesystemRule() {
  }

  public void applyRule(final SNode sync, final TypeCheckingContext typeCheckingContext, IsApplicableStatus status) {
    for (SNode ressource : ListSequence.fromList(SLinkOperations.getTargets(sync, "ressources", true))) {
      SNode ressourceType = TypeChecker.getInstance().getTypeOf(SLinkOperations.getTarget(ressource, "expression", true));
      if (SNodeOperations.isInstanceOf(ressourceType, "TasksAndSyncs.structure.SharedType")) {
        continue;
      }
      if (!(SNodeOperations.isInstanceOf(ressourceType, "com.mbeddr.core.pointers.structure.PointerType") && SNodeOperations.isInstanceOf(SLinkOperations.getTarget(SNodeOperations.cast(ressourceType, "com.mbeddr.core.pointers.structure.PointerType"), "baseType", true), "TasksAndSyncs.structure.SharedType"))) {
        {
          MessageTarget errorTarget = new NodeMessageTarget();
          IErrorReporter _reporter_2309309498 = typeCheckingContext.reportTypeError(ressource, "only shared ressource or pointer to shared ressource allowed", "r:daf934de-3466-4fa8-a227-270fedb7e2f2(TasksAndSyncs.typesystem)", "5853110027224839643", null, errorTarget);
        }
      }
    }
  }

  public String getApplicableConceptFQName() {
    return "TasksAndSyncs.structure.SyncStatement";
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
