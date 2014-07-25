package TasksAndSyncs.editor;

/*Generated by MPS */

import jetbrains.mps.openapi.editor.cells.EditorCell;
import org.jetbrains.mps.openapi.model.SNode;
import jetbrains.mps.openapi.editor.EditorContext;
import jetbrains.mps.openapi.editor.cells.CellActionType;
import jetbrains.mps.editor.runtime.cells.AbstractCellAction;
import jetbrains.mps.smodel.action.SNodeFactoryOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;

public class unnameRessource {
  public static void setCellActions(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setAction(CellActionType.DELETE, new unnameRessource.unnameRessource_DELETE(node));
    editorCell.setAction(CellActionType.BACKSPACE, new unnameRessource.unnameRessource_BACKSPACE(node));
  }

  public static class unnameRessource_DELETE extends AbstractCellAction {
    /*package*/ SNode myNode;

    public unnameRessource_DELETE(SNode node) {
      this.myNode = node;
    }

    public void execute(EditorContext editorContext) {
      this.execute_internal(editorContext, this.myNode);
    }

    public void execute_internal(EditorContext editorContext, SNode node) {
      SNode syncRessource = SNodeFactoryOperations.createNewNode("TasksAndSyncs.structure.SyncRessource", null);
      SLinkOperations.setTarget(syncRessource, "expression", SNodeOperations.copyNode(SLinkOperations.getTarget(node, "expression", true)), true);
      SNodeOperations.replaceWithAnother(node, syncRessource);
    }
  }

  public static class unnameRessource_BACKSPACE extends AbstractCellAction {
    /*package*/ SNode myNode;

    public unnameRessource_BACKSPACE(SNode node) {
      this.myNode = node;
    }

    public void execute(EditorContext editorContext) {
      this.execute_internal(editorContext, this.myNode);
    }

    public void execute_internal(EditorContext editorContext, SNode node) {
      SNode syncRessource = SNodeFactoryOperations.createNewNode("TasksAndSyncs.structure.SyncRessource", null);
      SLinkOperations.setTarget(syncRessource, "expression", SNodeOperations.copyNode(SLinkOperations.getTarget(node, "expression", true)), true);
      SNodeOperations.replaceWithAnother(node, syncRessource);
    }
  }
}
