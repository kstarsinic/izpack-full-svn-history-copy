/*
 *  $Id$
 *  IzPack
 *  Copyright (C) 2001-2003 Julien Ponge
 *
 *  File :               InstallPanel.java
 *  Description :        A panel to launch the installation process.
 *  Author's email :     julien@izforge.com
 *  Author's Website :   http://www.izforge.com
 *
 *  This program is free software; you can redistribute it and/or
 *  modify it under the terms of the GNU General Public License
 *  as published by the Free Software Foundation; either version 2
 *  of the License, or any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program; if not, write to the Free Software
 *  Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package com.izforge.izpack.panels;

import com.izforge.izpack.installer.*;
import com.izforge.izpack.util.*;

import java.awt.*;

import javax.swing.*;

/**
 *  The install panel class. Launches the actual installation job.
 *
 * @author     Julien Ponge
 * @created    November 1, 2002
 */
public class InstallPanel extends IzPanel implements AbstractUIProgressHandler
{
  /**  The layout. */
  private GridBagLayout layout;

  /**  The layout constraints. */
  private GridBagConstraints gbConstraints;

  /**  The tip label. */
  protected JLabel tipLabel;

  /**  The operation label . */
  protected JLabel packOpLabel;

  /**  The operation label . */
  protected JLabel overallOpLabel;

  /**  The pack progress bar. */
  protected JProgressBar packProgressBar;

  /**  The progress bar. */
  protected JProgressBar overallProgressBar;

  /**  True if the installation has been done. */
  private volatile boolean validated = false;

  /**  How many packs we are going to install. */
  private int noOfPacks = 0;

  /**
   *  The constructor.
   *
   * @param  parent  The parent window.
   * @param  idata   The installation data.
   */
  public InstallPanel(InstallerFrame parent, InstallData idata)
  {
    super(parent, idata);

    // We initialize our layout
    layout = new GridBagLayout();
    gbConstraints = new GridBagConstraints();
    setLayout(layout);

    int row = 1;

    this.tipLabel = new JLabel(parent.langpack.getString("InstallPanel.tip"),
      parent.icons.getImageIcon("tip"), JLabel.TRAILING);
    parent.buildConstraints(gbConstraints, 0, row++, 2, 1, 1.0, 0.0);
    gbConstraints.fill = GridBagConstraints.NONE;
    gbConstraints.anchor = GridBagConstraints.NORTHWEST;
    layout.addLayoutComponent(this.tipLabel, gbConstraints);
    add(this.tipLabel);

    this.packOpLabel = new JLabel(" ", JLabel.TRAILING);
    parent.buildConstraints(gbConstraints, 0, row++, 2, 1, 1.0, 0.0);
    gbConstraints.anchor = GridBagConstraints.SOUTHWEST;
    layout.addLayoutComponent(this.packOpLabel, gbConstraints);
    add(this.packOpLabel);

    this.packProgressBar = new JProgressBar();
    this.packProgressBar.setStringPainted(true);
    this.packProgressBar.setString(parent.langpack.getString("InstallPanel.begin"));
    this.packProgressBar.setValue(0);
    parent.buildConstraints(gbConstraints, 0, row++, 2, 1, 1.0, 0.0);
    gbConstraints.anchor = GridBagConstraints.NORTH;
    gbConstraints.fill = GridBagConstraints.HORIZONTAL;
    layout.addLayoutComponent(this.packProgressBar, gbConstraints);
    add(this.packProgressBar);

    // make sure there is some space between the progress bars
    JSeparator sep = new JSeparator ();
    Dimension dim = new Dimension (0, 10);
    sep.setPreferredSize (dim);
    sep.setMinimumSize (dim);
    sep.setMaximumSize (dim);
    parent.buildConstraints(gbConstraints, 0, row++, 2, 1, 1.0, 0.0);
    layout.addLayoutComponent(sep, gbConstraints);
    add(sep);

    this.overallOpLabel = new JLabel(parent.langpack.getString ("InstallPanel.progress"), 
      parent.icons.getImageIcon ("tip"), JLabel.TRAILING);
    parent.buildConstraints(gbConstraints, 0, row++, 2, 1, 1.0, 0.0);
    gbConstraints.anchor = GridBagConstraints.NORTHWEST;
    gbConstraints.fill = GridBagConstraints.NONE;
    layout.addLayoutComponent(this.overallOpLabel, gbConstraints);
    add(this.overallOpLabel);

    this.overallProgressBar = new JProgressBar();
    this.overallProgressBar.setStringPainted(true);
    this.overallProgressBar.setString("");
    this.overallProgressBar.setValue(0);
    parent.buildConstraints(gbConstraints, 0, row++, 2, 1, 1.0, 0.0);
    gbConstraints.anchor = GridBagConstraints.NORTH;
    gbConstraints.fill = GridBagConstraints.HORIZONTAL;
    layout.addLayoutComponent(this.overallProgressBar, gbConstraints);
    add(this.overallProgressBar);
  }


  /**
   *  Indicates wether the panel has been validated or not.
   *
   * @return    The validation state.
   */
  public boolean isValidated()
  {
    return this.validated;
  }


  /**  The unpacker starts.  */
  public void startAction (String name, int noOfJobs)
  {
    parent.blockGUI();
    // figure out how many packs there are to install
    this.noOfPacks = noOfJobs;
    this.overallProgressBar.setMinimum (1);
    this.overallProgressBar.setMaximum (this.noOfPacks);

    this.overallProgressBar.setString ("0 / " + Integer.toString (this.noOfPacks));
  }


  /**
   *  An error was encountered.
   *
   * @param  error  The error text.
   */
  public void errorUnpack(String error)
  {
    this.packOpLabel.setText(error);
    idata.installSuccess = false;
    JOptionPane.showMessageDialog(this, error.toString(),
      parent.langpack.getString("installer.error"),
      JOptionPane.ERROR_MESSAGE);
  }


  /**  The unpacker stops.  */
  public void stopAction()
  {
    parent.releaseGUI();
    parent.lockPrevButton();
    this.packProgressBar.setString(parent.langpack.getString("InstallPanel.finished"));
    this.packProgressBar.setEnabled(false);
    String no_of_packs = Integer.toString (this.noOfPacks);
    this.overallProgressBar.setString (no_of_packs + " / " + no_of_packs);
    this.overallProgressBar.setEnabled (false);
    this.packOpLabel.setText(" ");
    this.packOpLabel.setEnabled(false);
    idata.installSuccess = true;
    idata.canClose = true;
    this.validated = true;
    if (idata.panels.indexOf(this) != (idata.panels.size() - 1))
      parent.unlockNextButton();
  }


  /**
   *  Normal progress indicator.
   *
   * @param  val  The progression value.
   * @param  msg  The progression message.
   */
  public void progress(int val, String msg)
  {
    this.packProgressBar.setValue(val + 1);
    packOpLabel.setText(msg);
  }


  /**
   *  Pack changing.
   *
   * @param  packName  The pack name.
   * @param  stepno    The number of the pack.
   * @param  max       The new maximum progress.
   */
  public void nextStep(String packName, int stepno, int max)
  {
    this.packProgressBar.setValue(0);
    this.packProgressBar.setMinimum(0);
    this.packProgressBar.setMaximum(max);
    this.packProgressBar.setString(packName);

    this.overallProgressBar.setValue (stepno);
    this.overallProgressBar.setString (Integer.toString (stepno) + " / " + Integer.toString (this.noOfPacks));
  }


  /**
   * Ask the user whether the given file should be overwritten.
   *
   * @param file           The file in question.
   * @param default_choice Default choice from installation description.
   *
   * @return whether to overwrite the file.
   */
  public boolean askOverwrite (java.io.File file, boolean default_choice)
  {
    String yes = parent.langpack.getString ("installer.yes");
    String no = parent.langpack.getString ("installer.no");
    String[] choices = { yes, no };
    String initial = default_choice ? yes : no;
    String[] message = { parent.langpack.getString ("InstallPanel.overwrite.question"), file.getAbsolutePath() };

    int choice = JOptionPane.showOptionDialog (
        this, 
        (Object)message,
        parent.langpack.getString ("InstallPanel.overwrite.title"),
        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
        parent.icons.getImageIcon ("help"), 
        choices, initial);

    boolean result = default_choice;

    if (choice == JOptionPane.YES_OPTION)
    {
      result = true;
    }
    else if (choice == JOptionPane.NO_OPTION)
    {
      result = false;
    }

    return result;
  }

  /**
   * Something went wrong - show a warning.
   * 
   * @param message
   */
  public void showWarning (String message)
  {
    javax.swing.JOptionPane.showMessageDialog(null, message,
        "Installation warning",
        javax.swing.JOptionPane.WARNING_MESSAGE);
  }
  
  /**
   * Ask user for confirmation.
   * 
   * @param message
   * @return
   */
  public boolean askContinue (String message)
  {
    int result = javax.swing.JOptionPane.showConfirmDialog(null,
      message + " Would you like to proceed?",
      "Installation Warning",
      javax.swing.JOptionPane.YES_NO_OPTION);
    if (result != javax.swing.JOptionPane.YES_OPTION)
    {
      idata.installSuccess = false;
      return false;    
    }
    return true;
  }
  
  /**  Called when the panel becomes active.  */
  public void panelActivate()
  {
    // We clip the panel
    Dimension dim = parent.getPanelsContainerSize();
    dim.width = dim.width - (dim.width / 4);
    dim.height = 150;
    setMinimumSize(dim);
    setMaximumSize(dim);
    setPreferredSize(dim);
    parent.lockNextButton();

    parent.install(this);
  }

}

