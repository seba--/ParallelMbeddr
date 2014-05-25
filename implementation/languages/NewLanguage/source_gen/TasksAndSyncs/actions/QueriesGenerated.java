package TasksAndSyncs.actions;

/*Generated by MPS */

import java.util.List;
import jetbrains.mps.openapi.editor.cells.SubstituteAction;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.action.SideTransformActionsBuilderContext;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.smodel.action.AbstractSideTransformHintSubstituteAction;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import org.jetbrains.mps.openapi.model.SNode;
import org.jetbrains.annotations.Nullable;
import jetbrains.mps.openapi.editor.EditorContext;
import jetbrains.mps.smodel.action.SNodeFactoryOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.typesystem.inference.TypeChecker;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.smodel.constraints.ModelConstraints;
import jetbrains.mps.smodel.action.SideTransformPreconditionContext;

public class QueriesGenerated {
  public static List<SubstituteAction> sideTransform_ActionsFactory_Expression_6288388922744240693(final IOperationContext operationContext, final SideTransformActionsBuilderContext _context) {
    List<SubstituteAction> result = ListSequence.fromList(new ArrayList<SubstituteAction>());
    ListSequence.fromList(result).addElement(new AbstractSideTransformHintSubstituteAction(SConceptOperations.findConceptDeclaration("TasksAndSyncs.structure.SyncRessourceNamed"), _context.getSourceNode()) {
      public SNode doSubstitute(@Nullable final EditorContext editorContext, String pattern) {

        SNode ressourceNamed = SNodeFactoryOperations.createNewNode("TasksAndSyncs.structure.SyncRessourceNamed", null);
        if (SNodeOperations.isInstanceOf(TypeChecker.getInstance().getTypeOf(_context.getSourceNode()), "TasksAndSyncs.structure.SyncRessource")) {
          SLinkOperations.setTarget(ressourceNamed, "expression", SLinkOperations.getTarget(SNodeOperations.cast(_context.getSourceNode(), "TasksAndSyncs.structure.SyncRessource"), "expression", true), true);
          SNodeOperations.replaceWithAnother(_context.getSourceNode(), ressourceNamed);
        } else {
          SLinkOperations.setTarget(ressourceNamed, "expression", SNodeOperations.copyNode(SLinkOperations.getTarget(SNodeOperations.getAncestor(_context.getSourceNode(), "TasksAndSyncs.structure.SyncRessource", false, false), "expression", true)), true);
          SNodeOperations.replaceWithAnother(SNodeOperations.getAncestor(_context.getSourceNode(), "TasksAndSyncs.structure.SyncRessource", false, false), ressourceNamed);
        }
        return ressourceNamed;
      }

      public String getMatchingText(String pattern) {
        return "as";
      }

      public String getVisibleMatchingText(String pattern) {
        return getMatchingText(pattern);
      }

      @Override
      protected boolean isEnabled() {
        SNode sourceNode = getSourceNode();
        SNode parent = SNodeOperations.getParent(sourceNode);
        SNode containingLink = SNodeOperations.getContainingLinkDeclaration(sourceNode);
        return parent == null || containingLink == null || (ModelConstraints.canBeParent(parent, SConceptOperations.findConceptDeclaration("TasksAndSyncs.structure.SyncRessourceNamed"), containingLink, null, null) && ModelConstraints.canBeAncestor(parent, null, SConceptOperations.findConceptDeclaration("TasksAndSyncs.structure.SyncRessourceNamed"), null));
      }
    });
    return result;
  }

  public static boolean sideTransformHintSubstituteActionsBuilder_Precondition_Expression_6288388922745017488(final IOperationContext operationContext, final SideTransformPreconditionContext _context) {
    return SNodeOperations.getAncestor(_context.getSourceNode(), "TasksAndSyncs.structure.SyncRessource", false, false) != null;
  }
}
