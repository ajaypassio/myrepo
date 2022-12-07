/*
 * PEARSON PROPRIETARY AND CONFIDENTIAL INFORMATION SUBJECT TO NDA 
 * Copyright (c) 2018 Pearson Education, Inc.
 * All Rights Reserved. 
 * 
 * NOTICE: All information contained herein is, and remains the property of 
 * Pearson Education, Inc. The intellectual and technical concepts contained 
 * herein are proprietary to Pearson Education, Inc. and may be covered by U.S. 
 * and Foreign Patents, patent applications, and are protected by trade secret 
 * or copyright law. Dissemination of this information, reproduction of this  
 * material, and copying or distribution of this software is strictly forbidden   
 * unless prior written permission is obtained from Pearson Education, Inc.
 */
package com.pearson.glp.cms.constants;

/**
 * The Class LoggingConstants.
 */
public final class LoggingConstants {

  /** The Constant ERROR_NON_PRIMITIVE_ASSET_ROUTES. */
  public static final String ERROR_NON_PRIMITIVE_ASSET_ROUTES = "Error occurred registering NonPrimitiveAssetProvisioningRoutes Routes : ";
  /** The Constant GET_NON_PRIMITIVE_ASSETS_LOG_MESSAGE. */
  public static final String GET_NON_PRIMITIVE_ASSETS_LOG_MESSAGE = "Calling getNonPrimitiveAssets {}";
  /** The Constant CREATE_NON_PRIMITIVE_ASSETS_LOG_MESSAGE. */
  public static final String CREATE_NON_PRIMITIVE_ASSETS_LOG_MESSAGE = "Calling createNonPrimitiveAssets {}";
  /** The Constant GET_NON_PRIMITIVE_ASSET_BY_ID_LOG_MESSAGE. */
  public static final String GET_NON_PRIMITIVE_ASSET_BY_ID_LOG_MESSAGE = "Calling getNonPrimitiveAssetById {} with assetId : {}";
  /** The Constant GET_NON_PRIMITIVE_ASSET_VERSIONS_LOG_MESSAGE. */
  public static final String GET_NON_PRIMITIVE_ASSET_VERSIONS_LOG_MESSAGE = "Calling getNonPrimitiveAssetVersions {} with assetId : {}";
  /** The Constant CREATE_NON_PRIMITIVE_ASSET_VERSION_LOG_MESSAGE. */
  public static final String CREATE_NON_PRIMITIVE_ASSET_VERSION_LOG_MESSAGE = "Calling createNonPrimitiveAssetVersion {}";
  /** The Constant CREATE_PRODUCT_LOG_MESSAGE. */
  public static final String CREATE_PRODUCT_LOG_MESSAGE = "Calling createProduct {}";
  /** The Constant CREATE_PRODUCT_VERSION_LOG_MESSAGE. */
  public static final String CREATE_PRODUCT_VERSION_LOG_MESSAGE = "Calling createProductVersion {}";
  /** The Constant GET_NON_PRIMITIVE_ASSET_BY_VERSION_ID_LOG_MESSAGE. */
  public static final String GET_NON_PRIMITIVE_ASSET_BY_VERSION_ID_LOG_MESSAGE = "Calling getSpecificVersionOfNonPrimitiveAsset {} with assetId {} and versionId {}";
  /** The Constant ERROR_INVALID_URL. */
  public static final String ERROR_INVALID_URL = "Invalid URL. Mention valid search parameter for product.";
  /** The Constant FETCHING_PRODUCT_BY_VERSION. */
  public static final String FETCHING_PRODUCT_BY_VERSION = "Fetching Product By VER";
  /** The Constant FETCHING_PRODUCT_STATE_TRANSITION. */
  public static final String FETCHING_PRODUCT_STATE_TRANSITION = "Fetching state transition of product with id = {} and version= {}";
  /** The Constant FETCHING_PRODUCT_ASSESSMENT_TYPES. */
  public static final String FETCHING_PRODUCT_ASSESSMENT_TYPES = "Fetching ASSESSMENT type list of product with id = {} ";
  /** The Constant ERROR_REGISTERING_PRODUCT_ROUTES. */
  public static final String ERROR_REGISTERING_PRODUCT_ROUTES = "Error occurred registering Product Routes";
  /** The Constant FETCHING_PRODUCT_BY_ID. */
  public static final String FETCHING_PRODUCT_BY_ID = "Fetching Product By Id with Latest Version";
  /** The Constant GETTING_PRODUCT_VERSIONS. */
  public static final String GETTING_PRODUCT_VERSIONS = "Getting product versions";
  /** The Constant GETTING_PRODUCT_STATUS. */
  public static final String GETTING_PRODUCT_STATUS = "Getting product status with id = {} and version= {}";
  /** The Constant CREATING_NEW_PRODUCT_WITH_LATEST_VERSION. */
  public static final String POST_PRODUCT_VER_LOG = "Calling createNewProduct";
  /** The Constant PRODUCT_ROUTE. */
  public static final String POST_PRODUCT_LOG = "Calling postProduct";
  /** The Constant POST_PRODUCT_STATE_TRANSITION_LOG. */
  public static final String POST_PRODUCT_STATE_TRANSITION_LOG = "Calling postProductStateTransition";
  /** The Constant POST_MAP_ASSESSMENT_TYPE_LOG. */
  public static final String POST_MAP_ASSESSMENT_TYPE_LOG = "Calling postMapAssessmentType";
  /** The Constant PUT_PRODUCT_STATUS_LOG. */
  public static final String PUT_PRODUCT_STATUS_LOG = "Calling putProductStatus";
  /** The Constant GET_NARRATIVE_BYID_LOG. */
  public static final String GET_ASSESSMENT_BYID_LOG = "getSpecificAssessmentItemById Calling {}";
  /** The Constant GET_ASSESSMENT_ITEMS. */
  public static final String GET_ASSESSMENT_ITEMS = "getAssessmentItems Calling {}";
  /** The Constant GET_NARRATIVE_BYID_LOG. */
  public static final String GET_NARRATIVE_BYID_LOG = "getNarrativesById calling {} with id {}";
  /** The Constant CREATE_PRODUCT_LOG_MESSAGE. */
  public static final String ADD_ASSESSMENT_ITEM_LOG_MESSAGE = "Calling addAssetmentItem {}";
  /** The Constant POST_ASSESSMENT_ITEM_MODEL_LOG_MESSAGE. */
  public static final String POST_ASSESSMENT_ITEM_MODEL_LOG_MESSAGE = "Calling createAssessmentItemModel for {}";
  /** The Constant ADD_LEARNING_APP_ITEM_LOG_MESSAGE. */
  public static final String ADD_LEARNING_APP_ITEM_LOG_MESSAGE = "Calling addLearningAppItem {}";
  /** The Constant EXCEPTION_OCCURED. */
  public static final String EXCEPTION_OCCURED = "Exception occurred: {}";
  /** The Constant GET_PRODUCT_ASSET_TYPES_LOG. */
  public static final String GET_PRODUCT_ASSET_TYPES_LOG = "Calling getProductAssetTypes with {}";
  /** The Constant GET_LEARNINGAPP_BYID_LOG. */
  public static final String GET_LEARNINGAPP_BYID_LOG = "getSpecificLearningById Calling {}";

  /** The Constant GET_LEARNING_APP_BY_ID_AND_VERSION. */
  public static final String GET_LEARNING_APP_BY_ID_AND_VERSION = "getLearningAppItemsByIdAndVersion Calling {}";

  /** The Constant FORMATTED_DATE_AND_TIME. */
  public static final String FORMATTED_DATE_AND_TIME = "Formatted date and time {}";
  /** The Constant ERROR_LEARNING_APPS_ROUTES. */
  public static final String ERROR_LEARNING_APPS_ROUTES = "Error occurred registering learningAppsProvisioningRoutes Routes : ";

  /**
   * The Constant METHOD_POST_POLICY_FOR_PRODUCT_ASSESSMENT_RUNTIME_SETTINGS.
   */
  public static final String METHOD_POST_POLICY_FOR_PRODUCT_ASSESSMENT_RUNTIME_SETTINGS = "postPolicyForProductAssessmentRuntimeSettings";
  /** The Constant POLICY_PAYLOAD_CREATION_LOG. */
  public static final String POLICY_PAYLOAD_CREATION_LOG = "Creating payload for engagement policy.";

  /** The Constant RESOURCE_BY_ID_LOG. */
  public static final String RESOURCE_BY_ID_LOG = "resourceId : {}";

  /** The Constant METHOD_INVOCATION. */
  public static final String METHOD_INVOCATION = "method invocation : {} ";

  /** The Constant VALIDATE_RESOURCE_CATEGORY. */
  public static final String VALIDATE_RESOURCE_CATEGORY = "validateResourceCategory()";

  /** The Constant GET_RESOURCE_BY_ID_METHOD. */
  public static final String GET_RESOURCE_BY_ID_METHOD = "getResourceById()";

  /** The Constant RESOURCE_ID_AND_VERSION_LOGS. */
  public static final String RESOURCE_ID_AND_VERSION_LOGS = "getSpecificVersionOfResource calling {} with resourceId {} and versionId {}";

  /** The Constant GET_SPECIFIC_VERSION_RESOURCE_METHOD. */
  public static final String GET_SPECIFIC_VERSION_RESOURCE_METHOD = "getSpecificVersionOfResource()";

  /** The Constant METHOD_TERMINATION. */
  public static final String METHOD_TERMINATION = "method termination : {} ";

  /** The Constant ERROR_OCCURRED_REGISTERING_CMS_ROUTES. */
  public static final String ERROR_OCCURRED_REGISTERING_CMS_ROUTES = "Error occurred registering CMS Routes {}";

  /** The Constant ERROR_OCCURRED_REGISTERING_NARRATIVE_ROUTER_ROUTES. */
  public static final String ERROR_OCCURRED_REGISTERING_NARRATIVE_ROUTER_ROUTES = "Error occurred while registering Narrative Routes : ";

  /**
   * The Constant ERROR_OCCURRED_REGISTERING_ASSESSMENT_ITEMS_ROUTER_ROUTES.
   */
  public static final String ERROR_OCCURRED_REGISTERING_ASSESSMENT_ITEMS_ROUTER_ROUTES = "Error occurred registering Assessment Items Routes : ";

  /**
   * The Constant ERROR_OCCURRED_REGISTERING_LEARNING_APP_ITEMS_ROUTER_ROUTES.
   */
  public static final String ERROR_OCCURRED_REGISTERING_LEARNING_APP_ITEMS_ROUTER_ROUTES = "Error occurred registering learningAppItemsRouter Routes : ";

  /** The Constant ADD_LEARNING_APP_ITEMS. */
  public static final String ADD_LEARNING_APP_ITEMS = "addLearningAppItems";

  /** The Constant GET_LEARNING_APP_ITEMS_BY_ID. */
  public static final String GET_LEARNING_APP_ITEMS_BY_ID = "getLearningAppItemsById";

  /** The Constant GET_LEARNING_APP_ITEMS_BY_ID_AND_VERSION. */
  public static final String GET_LEARNING_APP_ITEMS_BY_ID_AND_VERSION = "getLearningAppItemsByIdAndVersion";
  /** The Constant PRODUCT_CONF_FETCH */
  public static final String CALLING_FOR_POLICY = "calling {} for policyGroups.";
  /** The Constant PRODUCT_CONF_FETCH_ERROR. */
  public static final String PRODUCT_CONF_FETCH_ERROR = "Unable to fetch product configuration for ID {} and version {}. {}";
  /** The Constant PRODUCT_CONFIGURATION_NOT_FOUND_LOG. */
  public static final String PRODUCT_CONFIGURATION_NOT_FOUND_LOG = "Product Configuration Not Found for product Id {} and ver {}.";

  /** The Constant CALLING_URL. */
  public static final String CALLING_URL = "Calling Url {}";
  /** The Constant CALLING_TO_POST_POLICY_GROUPS. */
  public static final String CALLING_TO_POST_POLICY_GROUPS = "calling {} to post policyGroups";
  /** The Constant CALLING_TO_POST_POLICY_GROUPS_VERSION. */
  public static final String CALLING_TO_POST_POLICY_GROUPS_VERSION = "calling {} to post policyGroups version";

  /** The Constant RENAME_LEARNING_AIDS. */
  public static final String RENAME_LEARNING_AIDS_LOG = "Renaming LearningAids";

  /** The Constant PRODUCT_LEARNINGAIDS_POLICY_ERROR. */
  public static final String PRODUCT_LEARNINGAIDS_POLICY_ERROR = "Unable to fetch product configuration for ID {} and version {}. {}";

  /** The Constant GET_PRODUCT_LEARNING_AIDS. */
  public static final String GET_PRODUCT_LEARNING_AIDS = "Get Product LearningAids for id {} and version {}";

  /** The Constant PRODUCT_LEARNINGAID_POLICY_FETCH */
  public static final String PRODUCT_LEARNINGAID_POLICY_FETCH = "calling {} LearningAid policy";

  /** The Constant PRODUCT_CONF_FETCH_ERROR. */
  public static final String LEARNING_AIDS_POLICY_CONFIGURATION = "Calling createDeliveryLearnidangAidsPolicy lad service to create Learning Aids with Product policy {} ";

  /** The Constant PRODUCT_CONF_FETCH_ERROR. */
  public static final String FILTER_INVALID_URL = "inside filter invalid url for {} request : {}";
  /** The Constant PRODUCT_CONF_FETCH_ERROR. */
  public static final String FILTER_INVALID_ACCEPT_HEADER = "inside filter required accept headers are missing in {} request for url : {}";
  /** The Constant PRODUCT_CONF_FETCH_ERROR. */
  public static final String FILTER_INVALID_CONTENT_TYPE_HEADER = "inside filter required content-type headers are missing in {} request for url : {}";

  /** The Constant ERROR_CALLING_LAE. */
  public static final String ERROR_CALLING_LAE = "error occured while calling LAE";

  /** The Constant GET_PRODUCT_ASSESSMENT_TYPE_BY_ID_AND_VERSION. */
  public static final String GET_PRODUCT_ASSESSMENT_TYPE_BY_ID_AND_VERSION = "Get Product Assessment Type By Id {} And Version {}.";

  /** The Constant GET_PRODUCT_ASSESSMENT_RUNTIME_SETTINGS_LOG. */
  public static final String GET_PRODUCT_ASSESSMENT_RUNTIME_SETTINGS_LOG = "Calling getProductAssessmentRunTimeSettings";

  /** The Constant GET_ALL_ASSESSMENT. */
  public static final String GET_ALL_ASSESSMENT = "Calling Get All Assessment";

  /** The Constant INVALID_QUERY_PARAM. */
  public static final String INVALID_QUERY_PARAM = "Invalid Query params used = {}.";

  /** The Constant PRODUCT_MODEL_CONFIGURATION_NOT_FOUND_LOG. */
  public static final String PRODUCT_MODEL_CONFIGURATION_NOT_FOUND_LOG = "Product model Configuration Not Found for product Id {} and ver {}.";

  /** The Constant PRODUCT_MODEL_CONF_FETCH_ERROR. */
  public static final String PRODUCT_MODEL_CONF_FETCH_ERROR = "Unable to fetch product model configuration for ID {} and version {}. {}";

  /** The Constant TIME_TAKEN_TO_FETCH_POLICY. */
  public static final String TIME_TAKEN_TO_FETCH_POLICY = "Time taken by LPB to get product model configuration: {} ";

  /** The Constant POLICY_FETCHED_SUCCESS. */
  public static final String POLICY_FETCHED_SUCCESS = "policyGroup fetched successfully.";

  /** The Constant CREATE_PRODUCT_MODEL_LEARNING_AIDS. */
  public static final String CREATE_PRODUCT_MODEL_LEARNING_AIDS = "createProductModelLearningAids";

  /** The Constant GET_PRODUCT_MODEL_CONFIGURATION. */
  public static final String GET_PRODUCT_MODEL_CONFIGURATION = "getProductModelConfiguration";

  /** The Constant GET_PRODUCT_MODEL_POLICY_GROUPS. */
  public static final String GET_PRODUCT_MODEL_POLICY_GROUPS = "getProductModelPolicyGroups";

  /** The Constant GET_POLICY_GROUPS_PRODUCT_MODEL_CONFIG. */
  public static final String GET_POLICY_GROUPS_PRODUCT_MODEL_CONFIG = "getPolicyGroupFromProductModelConfig";

  /** The Constant FETCHING_REQUEST_PARAM. */
  public static final String FETCHING_REQUEST_PARAM = "fetching request parameter {} : {}";

  /**
   * The Constant
   * METHOD_POST_POLICY_FOR_PRODUCT_MODEL_ASSESSMENT_RUNTIMESETTINGS.
   */
  public static final String METHOD_POST_POLICY_FOR_PRODUCT_MODEL_ASSESSMENT_RUNTIMESETTINGS = "postPolicyForProductModelAssessmentRuntimeSettings";

  /** The Constant PARAMETER. */
  public static final String PARAMETER = "Parameter {}={}";

  /** The Constant PRODUCT_RFC_MESSAGE_NOT_AVAILABLE. */
  public static final String PRODUCT_RFC_MESSAGE_NOT_AVAILABLE = "Product ready for configuration message does not exist.";

  /** The Constant PRODUCT_RFC_RECEIVING_EVENT_MESSAGE. */
  public static final String PRODUCT_RFC_RECEIVING_EVENT_MESSAGE = "Received product ready for configuration event.";

  /** The Constant ERROR_RECEIVING_EVENT_MESSAGE. */
  public static final String ERROR_RECEIVING_EVENT_MESSAGE = "Error while reading the event {}.";

  /** The Constant GET_PRODUCT_ASSESSMENT_TYPE_MESSAGE. */
  public static final String GET_PRODUCT_ASSESSMENT_TYPE_MESSAGE = "Assessment asset type fetched successfully.";

  /** The Constant DEFAULT_PRODUCT_MODEL_POLICY_FETCHED. */
  public static final String DEFAULT_PRODUCT_MODEL_POLICY_FETCHED = "Default product model policy fetched for {} ";
  /** The Constant POLICY_ERROR. */
  public static final String POLICY_ENGAGEMENT_ERROR = "Error while Creating policy for {} engagement failed {}";
  /** The Constant DEFAULT_RUNTIME_POLICY_EVALUATION_SUCCESS. */
  public static final String DEFAULT_RUNTIME_POLICY_EVALUATION_SUCCESS = "Default product runtime policy created for evaluation engagement. {}";
  /** The Constant DEFAULT_RUNTIME_POLICY_EXPERIENCE_SUCCESS. */
  public static final String DEFAULT_RUNTIME_POLICY_EXPERIENCE_SUCCESS = "Default product runtime policy created for experience engagement.{}";
  /** The Constant DEFAULT_RUNTIME_POLICY_DELIVERY_SUCCESS. */
  public static final String DEFAULT_RUNTIME_POLICY_DELIVERY_SUCCESS = "Default product runtime policy created for delivery engagement. {}";
  /** The Constant DEFAULT_PRODUCT_RUNTIME_POLICY_EVALUATION_ERROR. */
  public static final String DEFAULT_PRODUCT_RUNTIME_POLICY_EVALUATION_ERROR = "Error creating default product runtime policy for evaluation enagaement. {}";
  /** The Constant DEFAULT_PRODUCT_RUNTIME_POLICY_EXPERIENCE_ERROR. */
  public static final String DEFAULT_PRODUCT_RUNTIME_POLICY_EXPERIENCE_ERROR = "Error creating default product runtime policy for experience engagement. {}";
  /** The Constant DEFAULT_PRODUCT_RUNTIME_POLICY_DELIVERY_ERROR. */
  public static final String DEFAULT_PRODUCT_RUNTIME_POLICY_DELIVERY_ERROR = "Error creating default product runtime policy for delivery engagement. {}";
  /** The Constant FILTER_LEARNING_POLICY_METHOD. */
  public static final String FILTER_LEARNING_POLICY_METHOD = "filterLearningPolicy()";
  /** The Constant IS_ASSET_CLASS_MATCHED_METHOD. */
  public static final String IS_ASSET_CLASS_MATCHED_METHOD = "isAssetClassMatched()";
  /** The Constant GET_PRODUCT_MODEL_CATEGORY_WEIGHTS. */
  public static final String GET_PRODUCT_MODEL_CATEGORY_WEIGHTS = "Getting Product Model With Category Weights for id {} and version {}";
  /** The Constant GET_PRODUCT_MODEL_LEARNING_AIDS. */
  public static final String GET_PRODUCT_MODEL_LEARNING_AIDS = "Get Product Model LearningAids for id {} and version {}";
  /** The Constant GET_PRODUCT_SCORING_POLICY. */
  public static final String GET_PRODUCT_SCORING_POLICY_LOG = "Get Product Scoring Policy";
  /** The Constant GET_PRODUCT_SCORING_POLICY. */
  public static final String POST_PRODUCT_SCORING_POLICY_LOG = "Post Product Scoring Policy";
  /** The Constant GET_PRODUCT_SCORING_POLICY. */
  public static final String POST_PRODUCT_MODEL_SCORING_POLICY_LOG = "Post Product Model Scoring Policy";

  /** The Constant POST_PRODUCT_CATEGORY_WEIGHTS_LOG. */
  public static final String POST_PRODUCT_CATEGORY_WEIGHTS_LOG = "Calling postProductCategoryWeights";
  /** The Constant Post_ProductModel_Category_Weights. */
  public static final String Post_ProductModel_Category_Weights = "postProductModelCategoryWeights";

  /** The Constant CREATE_ASSESSMENT_RUNTIME_POLICY_RESPONSE. */
  public static final String CREATE_ASSESSMENT_RUNTIME_POLICY_RESPONSE = "createAssessmentRuntimePolicyResponse";

  /** The Constant CREATE_POLICY_DATA. */
  public static final String CREATE_POLICY_DATA = "createPolicyData";

  /** The Constant POST_ASSESSMENT_RUNTIME_SETTINGS_POLICY. */
  public static final String POST_ASSESSMENT_RUNTIME_SETTINGS_POLICY = "postAssessmentRuntimeSettingsPolicy";
  /** The Constant POST_PRODUCT_SCORING_POLICY. */
  public static final String POST_PRODUCT_SCORING_POLICY = "Calling postProductScoringPolicy";
  /** The Constant CALLING_FOR_RESOLVED_POLICY */
  public static final String CALLING_FOR_RESOLVED_POLICY = "calling {} for fetching resolved policies.";
  /** The Constant SCORING_POLICY_VERSION_FOR_PRODUCT */
  public static final String SCORING_POLICY_VERSION_FOR_PRODUCT_ERROR = "Post scoring policy version for {} engagement failed {}";
  /** The Constant TIME_TAKEN_TO_CREATE_POLICY */
  public static final String TIME_TAKEN_TO_CREATE_POLICY = "Time taken by {} to create policy: {} ";
  /** The Constant CALLING_SCORING_POLICY_RESOURCE. */
  public static final String CALLING_SCORING_POLICY_RESOURCE = "calling prepareScoringPolicyResource";
  /** The Constant GET_POLICIES_LOG. */
  public static final String GET_POLICIES_LOG = "Get Policies";
  /** The Constant GET_PRODUCT_POLICIES. */
  public static final String GET_PRODUCT_POLICIES = "Get Product Policies for id {} and version {}";
  /** The Constant GET_PRODUCT_MODEL_SCORING_POLICY_LOG. */
  public static final String GET_PRODUCT_MODEL_SCORING_POLICY_LOG = "Get Product Model Scoring Policy";
  /** The Constant TRANSFORMING_GET_POLICY_RESPONSE. */
  public static final String TRANSFORMING_GET_POLICY_RESPONSE = "Transforming get policy response.";

  /** The Constant METHOD_POST_ASSESSMENT_RUNTIMESETTINGS. */
  public static final String METHOD_POST_ASSESSMENT_RUNTIMESETTINGS = "postAssessmentRuntimeSettings";
  /** The Constant POST_CONFIG_STATUS_LOG. */
  public static final String POST_PRODUCT_CONFIG_STATUS_LOG = "Calling postProductConfigStatus";
  /** The Constant DEFAULT_RUNTIME_POLICY_EVALUATION_SUCCESS. */
  public static final String DEFAULT_SCORING_POLICY_FETCHED = "Default product scoring policy created successfully. {}";
  /** The Constant DEFAULT_SCORING_POLICY_ERROR. */
  public static final String DEFAULT_SCORING_POLICY_ERROR = "Error creating default product scoring policy in LAE. {}";
  /** The Constant CREATING_DEFAULT_PRODUCT_POLICY_PAYLOAD. */
  public static final String CREATING_DEFAULT_PRODUCT_POLICY_PAYLOAD = "Creating default product policy payload for {} from product model policy.";

  /** The Constant POST_CONFIG_STATUS_URL. */
  public static final String POST_CONFIG_STATUS_URL = "call configStatus with url {}";

  /** The Constant METHOD_GET_PRODUCT_MODEL_ASSESSMENT_RUNTIMESETTINGS. */
  public static final String METHOD_GET_PRODUCT_MODEL_ASSESSMENT_RUNTIMESETTINGS = "getProductModelAssessmentRunTimeSettings";

  /** The Constant UPDATE_SELF_LINK. */
  public static final String UPDATE_SELF_LINK = "updateSelfLink";

  /** The Constant CALLING_POLICY_RESOURCE. */
  public static final String CALLING_POLICY_RESOURCE = "calling preparePolicyResource";

  /** The Constant ERROR_REGISTERING_POLICY_ROUTES. */
  public static final String ERROR_REGISTERING_POLICY_ROUTES = "Error occurred registering Policy Routes";

  /**
   * Instantiates a new logging constants.
   */
  private LoggingConstants() {
    super();
  }
}
