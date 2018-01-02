/*
 * Copyright 2015-2018 Ping Identity Corporation
 * All Rights Reserved.
 */
/*
 * Copyright (C) 2015-2018 Ping Identity Corporation
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License (GPLv2 only)
 * or the terms of the GNU Lesser General Public License (LGPLv2.1 only)
 * as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, see <http://www.gnu.org/licenses>.
 */
package com.unboundid.ldap.sdk.unboundidds.tasks;



import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.unboundid.ldap.sdk.Entry;
import com.unboundid.util.NotMutable;
import com.unboundid.util.ThreadSafety;
import com.unboundid.util.ThreadSafetyLevel;

import static com.unboundid.ldap.sdk.unboundidds.tasks.TaskMessages.*;



/**
 * This class defines a Directory Server task that can be used to synchronize
 * the encryption settings definitions in one instance with one or more other
 * servers in the topology.  This task does not have any task-specific
 * properties.
 * <BR>
 * <BLOCKQUOTE>
 *   <B>NOTE:</B>  This class, and other classes within the
 *   {@code com.unboundid.ldap.sdk.unboundidds} package structure, are only
 *   supported for use against Ping Identity, UnboundID, and Alcatel-Lucent 8661
 *   server products.  These classes provide support for proprietary
 *   functionality or for external specifications that are not considered stable
 *   or mature enough to be guaranteed to work in an interoperable way with
 *   other types of LDAP servers.
 * </BLOCKQUOTE>
 */
@NotMutable()
@ThreadSafety(level=ThreadSafetyLevel.COMPLETELY_THREADSAFE)
public final class SynchronizeEncryptionSettingsTask
       extends Task
{
  /**
   * The fully-qualified name of the Java class that is used for the synchronize
   * encryption settings task.
   */
  static final String SYNCHRONIZE_ENCRYPTION_SETTINGS_TASK_CLASS =
       "com.unboundid.directory.server.crypto." +
            "SynchronizeEncryptionSettingsTask";



  /**
   * The name of the object class used in synchronize encryption settings task
   * entries.
   */
  private static final String OC_SYNCHRONIZE_ENCRYPTION_SETTINGS_TASK =
       "ds-task-synchronize-encryption-settings";



  /**
   * The serial version UID for this serializable class.
   */
  private static final long serialVersionUID = 5176601759135180183L;



  /**
   * Creates a new uninitialized synchronize encryption settings task instance
   * that should only be used for obtaining general information about this task,
   * including the task name, description, and supported properties.
   */
  public SynchronizeEncryptionSettingsTask()
  {
    this(null, null, null, null, null, null);
  }



  /**
   * Creates a new synchronize encryption settings task with the provided
   * information.
   *
   * @param  taskID         The task ID to use for this task.  If it is
   *                        {@code null} then a UUID will be generated for use
   *                        as the task ID.
   */
  public SynchronizeEncryptionSettingsTask(final String taskID)
  {
    this(taskID, null, null, null, null, null);
  }



  /**
   * Creates a new synchronize encryption settings task with the provided
   * information.
   *
   * @param  taskID                  The task ID to use for this task.  If it is
   *                                 {@code null} then a UUID will be generated
   *                                 for use as the task ID.
   * @param  scheduledStartTime      The time that this task should start
   *                                 running.
   * @param  dependencyIDs           The list of task IDs that will be required
   *                                 to complete before this task will be
   *                                 eligible to start.
   * @param  failedDependencyAction  Indicates what action should be taken if
   *                                 any of the dependencies for this task do
   *                                 not complete successfully.
   * @param  notifyOnCompletion      The list of e-mail addresses of individuals
   *                                 that should be notified when this task
   *                                 completes.
   * @param  notifyOnError           The list of e-mail addresses of individuals
   *                                 that should be notified if this task does
   *                                 not complete successfully.
   */
  public SynchronizeEncryptionSettingsTask(final String taskID,
              final Date scheduledStartTime, final List<String> dependencyIDs,
              final FailedDependencyAction failedDependencyAction,
              final List<String> notifyOnCompletion,
              final List<String> notifyOnError)
  {
    super(taskID, SYNCHRONIZE_ENCRYPTION_SETTINGS_TASK_CLASS,
         scheduledStartTime, dependencyIDs, failedDependencyAction,
         notifyOnCompletion, notifyOnError);
  }



  /**
   * Creates a new synchronize encryption settings task from the provided entry.
   *
   * @param  entry  The entry to use to create this synchronize encryption
   *                settings task.
   *
   * @throws  TaskException  If the provided entry cannot be parsed as a
   *                         synchronize encryption settings task entry.
   */
  public SynchronizeEncryptionSettingsTask(final Entry entry)
         throws TaskException
  {
    super(entry);
  }



  /**
   * Creates a new synchronize encryption settings task from the provided set of
   * task properties.
   *
   * @param  properties  The set of task properties and their corresponding
   *                     values to use for the task.  It must not be
   *                     {@code null}.
   *
   * @throws  TaskException  If the provided set of properties cannot be used to
   *                         create a valid synchronize encryption settings
   *                         task.
   */
  public SynchronizeEncryptionSettingsTask(
              final Map<TaskProperty,List<Object>> properties)
         throws TaskException
  {
    super(SYNCHRONIZE_ENCRYPTION_SETTINGS_TASK_CLASS, properties);
  }



  /**
   * {@inheritDoc}
   */
  @Override()
  public String getTaskName()
  {
    return INFO_TASK_NAME_SYNCHRONIZE_ENCRYPTION_SETTINGS.get();
  }



  /**
   * {@inheritDoc}
   */
  @Override()
  public String getTaskDescription()
  {
    return INFO_TASK_DESCRIPTION_SYNCHRONIZE_ENCRYPTION_SETTINGS.get();
  }



  /**
   * {@inheritDoc}
   */
  @Override()
  protected List<String> getAdditionalObjectClasses()
  {
    return Collections.singletonList(OC_SYNCHRONIZE_ENCRYPTION_SETTINGS_TASK);
  }
}
