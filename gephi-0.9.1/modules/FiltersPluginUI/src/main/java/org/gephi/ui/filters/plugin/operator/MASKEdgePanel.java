/*
Copyright 2008-2010 Gephi
Authors : Mathieu Bastian <mathieu.bastian@gephi.org>
Website : http://www.gephi.org

This file is part of Gephi.

DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.

Copyright 2011 Gephi Consortium. All rights reserved.

The contents of this file are subject to the terms of either the GNU
General Public License Version 3 only ("GPL") or the Common
Development and Distribution License("CDDL") (collectively, the
"License"). You may not use this file except in compliance with the
License. You can obtain a copy of the License at
http://gephi.org/about/legal/license-notice/
or /cddl-1.0.txt and /gpl-3.0.txt. See the License for the
specific language governing permissions and limitations under the
License.  When distributing the software, include this License Header
Notice in each file and include the License files at
/cddl-1.0.txt and /gpl-3.0.txt. If applicable, add the following below the
License Header, with the fields enclosed by brackets [] replaced by
your own identifying information:
"Portions Copyrighted [year] [name of copyright owner]"

If you wish your version of this file to be governed by only the CDDL
or only the GPL Version 3, indicate your decision by adding
"[Contributor] elects to include this software in this distribution
under the [CDDL or GPL Version 3] license." If you do not indicate a
single choice of license, a recipient has the option to distribute
your version of this file under either the CDDL, the GPL Version 3 or
to extend the choice of license to its licensees as provided above.
However, if you add GPL Version 3 code and therefore, elected the GPL
Version 3 license, then the option applies only if the new code is
made subject to such option by the copyright holder.

Contributor(s):

Portions Copyrighted 2011 Gephi Consortium.
 */
package org.gephi.ui.filters.plugin.operator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.gephi.filters.plugin.operator.MASKBuilderEdge;

/**
 *
 * @author Mathieu Bastian
 */
public class MASKEdgePanel extends javax.swing.JPanel implements ActionListener {

    private MASKBuilderEdge.MaskEdgeOperator operator;

    public MASKEdgePanel() {
        initComponents();
        anyButton.addActionListener(this);
        bothButton.addActionListener(this);
        sourceButton.addActionListener(this);
        targetButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (operator != null) {
            MASKBuilderEdge.MaskEdgeOperator.EdgesOptions option = MASKBuilderEdge.MaskEdgeOperator.EdgesOptions.ANY;
            if (bothButton.isSelected()) {
                option = MASKBuilderEdge.MaskEdgeOperator.EdgesOptions.BOTH;
            } else if (sourceButton.isSelected()) {
                option = MASKBuilderEdge.MaskEdgeOperator.EdgesOptions.SOURCE;
            } else if (targetButton.isSelected()) {
                option = MASKBuilderEdge.MaskEdgeOperator.EdgesOptions.TARGET;
            }
            operator.getProperties()[0].setValue(option.toString());
        }
    }

    public void setup(MASKBuilderEdge.MaskEdgeOperator operator) {
        this.operator = operator;
        MASKBuilderEdge.MaskEdgeOperator.EdgesOptions option = MASKBuilderEdge.MaskEdgeOperator.EdgesOptions.valueOf(operator.getOption());
        switch(option) {
            case ANY:
                anyButton.setSelected(true);
                break;
            case BOTH:
                bothButton.setSelected(true);
                break;
            case SOURCE:
                sourceButton.setSelected(true);
                break;
            case TARGET:
                targetButton.setSelected(true);
                break;
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        group = new javax.swing.ButtonGroup();
        sourceButton = new javax.swing.JRadioButton();
        targetButton = new javax.swing.JRadioButton();
        anyButton = new javax.swing.JRadioButton();
        bothButton = new javax.swing.JRadioButton();

        setLayout(new java.awt.GridBagLayout());

        group.add(sourceButton);
        sourceButton.setText(org.openide.util.NbBundle.getMessage(MASKEdgePanel.class, "MASKEdgePanel.sourceButton.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        add(sourceButton, gridBagConstraints);

        group.add(targetButton);
        targetButton.setText(org.openide.util.NbBundle.getMessage(MASKEdgePanel.class, "MASKEdgePanel.targetButton.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        add(targetButton, gridBagConstraints);

        group.add(anyButton);
        anyButton.setSelected(true);
        anyButton.setText(org.openide.util.NbBundle.getMessage(MASKEdgePanel.class, "MASKEdgePanel.anyButton.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        add(anyButton, gridBagConstraints);

        group.add(bothButton);
        bothButton.setText(org.openide.util.NbBundle.getMessage(MASKEdgePanel.class, "MASKEdgePanel.bothButton.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        add(bothButton, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton anyButton;
    private javax.swing.JRadioButton bothButton;
    private javax.swing.ButtonGroup group;
    private javax.swing.JRadioButton sourceButton;
    private javax.swing.JRadioButton targetButton;
    // End of variables declaration//GEN-END:variables
}
